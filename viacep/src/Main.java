import Estruturas.lukoki.ao.Consumo;
import Estruturas.lukoki.ao.Endereco;
import Estruturas.lukoki.ao.PegarEndecoViaApi;
import Excessoes.erroDeCoonsumo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        Scanner leitura = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
        String cep;
        boolean permanecerMenu= true;
        while(permanecerMenu){
            System.out.println("1- Pesquisar localidade por cep");
            System.out.println("2- Visualizar as pesquisas feitas");
            System.out.println("0- Sair");
            System.out.print("escolher uma opcão ");
            opcao = leitura.nextInt();
            switch (opcao){
                case 1:
                    leitura.nextLine();
                    System.out.println("PESQUISAR A LOCALIDADE POR CEP");
                    System.out.print("Digite o seu cep sem o simbolo de traço ");
                    cep = leitura.nextLine();
                    String link = "https://viacep.com.br/ws/"+cep+"/json/";
                    Consumo consumo = new Consumo();
                    try {
                        String response = consumo.consumindoApi(link);
                        System.out.println(response);
                        PegarEndecoViaApi pegarEndecoViaApi = consumo.converterEmGson(response);
                        Endereco meuEndereco = new Endereco(pegarEndecoViaApi);
                        enderecos.add(meuEndereco);


                    }catch (erroDeCoonsumo e){

                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    if (enderecos.size()!=0){
                        for (Endereco lista : enderecos){
                            System.out.println("---------------------------------------------");
                            System.out.println("Localização cep "+lista.getCep());
                            System.out.println("logradouro "+lista.getLogradouro());
                            System.out.println("complemento "+lista.getClass());
                            System.out.println("bairro "+lista.getBairro());
                            System.out.println("localidade "+lista.getLocalidade());
                            System.out.println("uf "+lista.getUf());
                            System.out.println("ibge "+lista.getIbge());
                            System.out.println("gia "+lista.getGia());
                            System.out.println("ddd "+lista.getDdd());
                            System.out.println("siafi "+lista.getSiafi());
                            System.out.println("---------------------------------------------");
                        }
                    }else{
                        System.out.println("lista vazia");
                    }
                    break;
                case 0:
                    FileWriter escrever = null;
                    try {
                        escrever = new FileWriter("endereco.json");
                        escrever.write(gson.toJson(enderecos));
                        escrever.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    permanecerMenu=false;
                    break;
                default:
                    System.out.println("opção errada tente novamente");
            }
        }

    }
}