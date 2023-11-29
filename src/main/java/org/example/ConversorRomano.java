package org.example;

public class ConversorRomano {

    public static String paraRomano(int numero) {
        if (numero <= 0 || numero > 3999) {
            throw new IllegalArgumentException("O número não pode ser convertido para algarismos romanos.");
        }

        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < simbolos.length; i++) {
            while (numero >= valores[i]) {
                resultado.append(simbolos[i]);
                numero -= valores[i];
            }
        }

        return resultado.toString();
    }

    public static int paraDecimal(String romano) {
        String[] simbolos = {"M", "D", "C", "L", "X", "V", "I"};
        int[] valores = {1000, 500, 100, 50, 10, 5, 1};

        int resultado = 0;

        for (int i = 0; i < romano.length(); i++) {
            char atual = romano.charAt(i);
            int valorAtual = 0;

            for (int j = 0; j < simbolos.length; j++) {
                if (simbolos[j].charAt(0) == atual) {
                    valorAtual = valores[j];
                    break;
                }
            }

            if (i < romano.length() - 1) {
                char proximo = romano.charAt(i + 1);

                for (int j = 0; j < simbolos.length; j++) {
                    if (simbolos[j].charAt(0) == proximo) {
                        if (valores[j] > valorAtual) {
                            resultado += (valores[j] - valorAtual);
                            i++;
                            break;
                        } else {
                            resultado += valorAtual;  // Adiciona o valor atual ao resultado
                        }
                    }
                }
            } else {
                resultado += valorAtual;
            }

            if (valorAtual == 0) {
                throw new IllegalArgumentException("Símbolo romano inválido: " + atual);
            }
        }

        return resultado;
    }

}
