package pt.evote.evote;

import android.app.Application;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Calendar;

import pt.evote.evote.model.Eleicao;
import pt.evote.evote.model.EleicaoCompleta;
import pt.evote.evote.model.EleicaoSimples;
import pt.evote.evote.model.Noticia;
import pt.evote.evote.model.User;

public class eVoteApplication extends Application {

    User loggedInUser;
    private Boolean loggedIn = false;

    @Override
    public void onCreate() {
        super.onCreate();

        if (logBack()) {
            setLoggedIn(true);
        }
    }

    public boolean logBack() {
        //If the user has logged in in the past, fetch saved credentials and login again


        //loggedInUser = logIn("savedName", "savedPass");
        return false;
    }

    public User logIn(String user, String pass) throws Exception {
        //Just a dummy

        //wait a bit to simulate network activity

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new Exception("Failed to Login");
        }

        setLoggedIn(true);
        return new User();
    }

    public boolean logOut() {

        return true;
    }

    public void fetchElections(ArrayList<Eleicao> listEleicao) {

        //fetch elections from the internet....
        //We just pretend in here, tho

        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.HOUR, 8);

        Calendar close = rightNow;
        close.add(Calendar.HOUR, 18);

        EleicaoCompleta o1 = new EleicaoCompleta(1, "Associação Académica de Coimbra - OAF", "", rightNow.getTime(), close.getTime());
        o1.setInscrito(true);

        rightNow.add(Calendar.DAY_OF_MONTH, 1);
        close.add(Calendar.DAY_OF_MONTH, 1);
        EleicaoCompleta o2 = new EleicaoCompleta(2, "Automóvel Clube de Portugal - ACP", "", rightNow.getTime(), close.getTime());

        rightNow.add(Calendar.DAY_OF_MONTH, 7);
        close.add(Calendar.DAY_OF_MONTH, 7);
        Eleicao o3 = new EleicaoSimples(3, "Câmara Municipal de Coimbra", "", rightNow.getTime(), close.getTime());


        o1.addNoticia(new Noticia("Eleições para a Associação Académica de Coimbra começam hoje, com dois candidatos",
                "As eleições para a direção-geral da Associação Académica de Coimbra (AAC) começam hoje e terminam na terça-feira, contando com dois candidatos à liderança da mais antiga associação de estudantes do país.",
                "rtp.pt", "https://www.rtp.pt/noticias/pais/eleicoes-para-a-associacao-academica-de-coimbra-comecam-hoje-com-dois-candidatos_n965443", "28/11/2016", getResourceUri("academica").toString()));

        o1.addNoticia(new Noticia("Notícia de exemplo sobre a Académica", "Aqui ficará a descrição", "sapo.pt", "sapo.pt", "26/06/2017", null));
        o2.addNoticia(new Noticia("Notícia de exemplo sobre a ACP", "Aqui ficará a descrição", "sapo.pt", "sapo.pt", "26/06/2017", null));

        o2.addNoticia(new Noticia("Notícia de exemplo sobre a ACP", "Aqui ficará a descrição", "sapo.pt", "sapo.pt", "21/04/2017", getResourceUri("image").toString()));

        listEleicao.add(o3);
        listEleicao.add(o2);
        listEleicao.add(o1);

    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    private Uri getResourceUri(String name) {
        return Uri.parse("android.resource://" + this.getApplicationContext().getPackageName() + "/drawable/" + name);
    }
}
