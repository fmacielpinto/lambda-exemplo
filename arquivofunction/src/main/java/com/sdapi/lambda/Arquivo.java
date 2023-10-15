package com.sdapi.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Base64;

import com.sdapi.model.Headers;
import com.sdapi.model.Retorno;
import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;


/**
 * Handler for requests to Lambda function.
 */
public class Arquivo implements RequestStreamHandler {

    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

        LambdaLogger logger = context.getLogger();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String base64 = "";
        try {
            String data = "";
            String line;
            while ((line = reader.readLine()) != null) {
                data += line;
            }

            logger.log("Conteudo: " + data); ;

            JSONObject event = new JSONObject(data);

            base64 = (String) event.get("body");


            logger.log("Conteudo base64: " + base64);

            byte[] decodedBytes = Base64.getDecoder().decode(base64);
            String decodedString = new String(decodedBytes);
            logger.log("Conteudo Arquivo: " + decodedString);


            JSONObject entidade = new JSONObject(decodedString);


            logger.log("Conteudo event: " + entidade.getString("nome"));


            output.write(retornoSucesso().getBytes());

            logger.log("output: " + output.toString());
        } catch (Exception e) {
            output.write(retornoFalha(e).getBytes());
            e.printStackTrace();
        }

    }

    private String retornoSucesso() {
        Retorno r = new Retorno();
        r.setBase64Encoded(false);
        r.setStatusCode(200);
        r.setBody("{\"codigo\":\"01\",\"mensagem\":\"Carregado com sucesso! \"}");
        Headers headers = new Headers();
        headers.setContentType("application/json");
        r.setHeaders(headers);
        Gson gson = new Gson();
        return  gson.toJson(r);
    }

    private String retornoFalha(Exception e) {
        Retorno r = new Retorno();
        r.setBase64Encoded(false);
        r.setStatusCode(200);
        r.setBody("{\"codigo\":\"02\",\"mensagem\":\"Erro ao processar o arquivo! "+e.getMessage()+" \"}");
        Headers headers = new Headers();
        headers.setContentType("application/json");
        r.setHeaders(headers);
        Gson gson = new Gson();
        return  gson.toJson(r);
    }

}

