package xml.adapter;

import model.TipoAtividade;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TipoAtividadeAdapter extends XmlAdapter<String, TipoAtividade> {

    @Override
    public TipoAtividade unmarshal(String v) throws Exception {
        return TipoAtividade.valueOf(v.toUpperCase()); //ok

    }

    @Override
    public String marshal(TipoAtividade v) throws Exception {
        return v.getValor();
    }
}
