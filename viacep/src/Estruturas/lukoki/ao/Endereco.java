package Estruturas.lukoki.ao;

public class Endereco {
    private  String cep;
    private  String logradouro;
    private  String complemento;
    private  String localidade;
    private  String uf;
    private  String ibge;
    private  String gia;
    private  String ddd;
    private  String siafi;
    private  String bairro;

    public Endereco(PegarEndecoViaApi pegarEndecoViaApi) {
        this.cep =pegarEndecoViaApi.cep();
        this.logradouro = pegarEndecoViaApi.logradouro();
        this.complemento = pegarEndecoViaApi.complemento();
        this.localidade = pegarEndecoViaApi.localidade();
        this.uf = pegarEndecoViaApi.uf();
        this.bairro = pegarEndecoViaApi.bairro();
        this.ibge = pegarEndecoViaApi.ibge();
        this.gia = pegarEndecoViaApi.gia();
        this.ddd = pegarEndecoViaApi.ddd();
        this.siafi = pegarEndecoViaApi.siafi();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    @Override
    public String toString() {
        return "{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                ", ddd='" + ddd + '\'' +
                ", siafi='" + siafi + '\'' +
                '}';
    }
}