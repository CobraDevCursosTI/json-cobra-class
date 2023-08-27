package br.com.cobradev.jsoncobraclass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static br.com.cobradev.jsoncobraclass.Constants.*;

public class Transform {

    public String toClass(String json) {

        // Separa o json em linhas num array
        String[] lines = json.split(",");

        // Remove a chave de abertura do json da primeira linha
        lines[0] = lines[0].replace("{", "");

        // Remove a chave de fechamento do json da última linha
        lines[lines.length - 1] = lines[lines.length - 1].replace("}", "");

        // Remove espaçamentos e aspas duplas
        List<String> linesList = Arrays.stream(lines)
                .map(String::trim)
                .map(line -> line.replace("\"", ""))
                .collect(Collectors.toList());

        // Cria map com chave e valor do json
        Map<String, Object> mapLines = new HashMap<>();
        for (String line : linesList) {
            mapLines.put(line.split(":")[0], line.split(":")[1]);
        }

        // StringBuilder de retorno da classe montada
        StringBuilder retorno = new StringBuilder("public class Root {").append(LINE_BREAK);

        mapLines.forEach((key, value) ->
            retorno
                .append(Constants.INDENTATION)
                .append(PRIVATE).append(SPACE)
                .append(STRING).append(SPACE)
                .append(key).append(COMMA).append(LINE_BREAK)
        );

        // Acrescenta chave de fechamento no final da classe
        retorno.append("}");

        // Retorna a classe montada
        return retorno.toString();
    }
}
