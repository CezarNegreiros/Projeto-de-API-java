package principal;

import modelos.meuEndereco;

import java.util.Scanner;

public class cep {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        meuEndereco meuEndereco = new meuEndereco();

        //Interface onde o usuário coloca o seu CEP
        System.out.print("Insira o seu CEP: ");
        meuEndereco.setCep(leitor.nextLine());

        //Printa na tela as informações contidas no JSON
        System.out.println(meuEndereco.consultaCep(meuEndereco.getCep()));

        //Cria o arquivo com as informações do json
        meuEndereco.arquivoCEP();
    }
}
