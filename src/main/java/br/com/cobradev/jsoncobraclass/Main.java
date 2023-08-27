package br.com.cobradev.jsoncobraclass;

public class Main {
    public static void main(String[] args) {
        String json = """
            {
                "cep": "01001-000",
                "logradouro": "Praça da Sé",
                "complemento": "lado ímpar",
                "bairro": "Sé",
                "localidade": "São Paulo",
                "uf": "SP",
                "ibge": "3550308",
                "gia": "1004",
                "ddd": "11",
                "siafi": "7107"
            }
        """;

        Transform transform = new Transform();
        System.out.println(transform.toClass(json));
    }
}