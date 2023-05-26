package com.sintel.lesvoiesdeleternel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListeCantiquesActivity extends AppCompatActivity {

    public static int pos;
    public static String motif_recherche = "";
    ListView listView;
    private ArrayList<Integer> positions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_cantiques);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_HOME);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_listecantique);

        listView = findViewById(R.id.ListeCantiques);
        SearchView searchView = findViewById(R.id.searchView);
        rechercher();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                motif_recherche = newText;
                rechercher();
                return false;
            }
        });
    }

    public ArrayList<String> rechercher(){
        final ArrayList<String> sortie = new ArrayList<>();
        positions = new ArrayList<>();
        for(int i = 1 ; i < liste_titre_cantiques.length + 1; i ++){
            if(liste_titre_cantiques[i - 1].toLowerCase().contains(motif_recherche.toLowerCase())){
                sortie.add(liste_titre_cantiques[i - 1]);
                positions.add(i - 1);
            }
        }
        Log.e("LISTE", sortie.toString());
        final CustomAdapter customAdapter = new CustomAdapter(sortie.toArray());
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListeCantiquesActivity.this, CantiqueActivity.class);
                intent.putExtra("position", positions.get(position));
                startActivity(intent);
            }
        });
        return sortie;
    }

    public class CustomAdapter extends BaseAdapter {

        private Object[] liste;
        CustomAdapter(){
            liste = liste_titre_cantiques;
        }
        CustomAdapter(Object liste1[]){
            liste = liste1;
        }

        @Override
        public int getCount() {
            return liste.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom_layout, null);
            // ImageView imageView = (ImageView) view.findViewById(R.id.ImageCantique);
            TextView textView_name = (TextView) view.findViewById(R.id.titleText);
            TextView textView_numero = (TextView) view.findViewById(R.id.numero);
            //imageView.setImageResource(R.drawable.ic_music_note_black_24dp);
            textView_numero.setText(""+(positions.get(position)+1));
            textView_name.setText(liste[position].toString());
            return view;
        }
    }

    public static String[] liste_titre_cantiques = {
            " Tes voies, seigneur, je veux   célébrer ",
            " O mon Dieu de toutes grâces,  je  te prie ",
            " Appelés à la liberté",
            " Qui  survivra jusqu’à la fin",
            " Frères ne  nous laissons pas,  et tenons   ferme au combat   ",
            " Oui, l’espérance   de l’Evangile est certaine  ",
            " Prends  l’armure de Dieu, l’épée de l’esprit ",
            " Plus que vainqueurs! Telle est notre devise  ",
            " A celui qui sera vainqueurs   ",
            " Que tout genou fléchisse   ",
            " Béni soit le lien ",
            " Ah! Qu’il est beau de voir  des frères  ",
            " Que ton joug est facile! ",
            " Sans attendre ",
            " Quand Dieu te fait passer  ",
            " Un réveil de sanctification passe au pays ",
            " Christ dans la chair ouvrit une voie ",
            " Je  me  réjouis du salut, je me réjouis en Dieu ",
            " Pries et tu recevras ",
            " Crois la parole  de  Dieu ",
            " O Jésus,  toi mon sauveur, que  ton nom  soit béni  ",
            " Quiconque au maître veut ressembler  ",
            " Jésus, mon sauveur, à   toi je veux être ",
            " Dieu est bon il nous  a donné son fils ",
            " Jésus mon sauveur, je te prie ",
            " Hâte-toi vers le  but, est l’ordre de notre Dieu ",
            " La lumière est venue  au monde ",
            "   Merci, notre Dieu, d’avoir réuni ",
            " Dans la foi d’Abraham  nous marchons   ",
            " Cher Jésus,  apprends-moi  a  bien te prier  ",
            "  Pour avoir communion avec Dieu ",
            " Un jour, j’ai pu  voir mon esprit ",
            "  Celui qui  met en Jésus ",
            " Jésus  ouvrit  la bouche   et dit: ",
            "  Donnes-moi un Cœur fermé pour le péché ",
            " Jésus, donne-moi, je te prie ",
            " La louange  a commencé  ",
            " Des  temps nouveaux ont commencé ",
            " Le temps est court, et bientôt vient la nuit ",
            " Pourquoi ne serions-nous pas toujours dans la joie? ",
            " Il est temps d’aller de l’avant ",
            " Notre vieil homme fut crucifié ",
            " L’heure du seigneur est venue pour nous tous, maintenant  ",
            " Je vois mon sauveur, en esprit  ",
            " Qui est celle-là qui monte du désert ",
            " Louons les œuvres  du seigneur ",
            " Je te remercie, cher seigneur ",
            " A tes pieds, o divin Maître  ",
            " Seigneur, laisse-moi  toujours être  ",
            " La voix du seigneur m’appelle ",
            " Si je parlais le plus parfait langage ",
            " Mon lot est délicieux, mon cœur se réjouit",
            " De toi repousse d’emblée ",
            " Je veux chanter les commandements ",
            " Es-tu un membre du corps de Jésus Christ? ",
            " Travaillons et luttons! Nous sommes au seigneur   ",
            " Qu’il fait bon à ton service ",
            " Tu mets l’amour bouillant ",
            " Je chanterai  Sion, belle cite!  ",
            " L’Évangiles de la croix est un scandale pour ceux ",
            " A toi, mon Dieu, je m’abandonnes ",
            " Pour la moisson les champs blanchissent  ",
            " Magnifique fraternité ",
            " Oh quel parfait et grand bonheur ",
            " Les jours du fils de l’homme ",
            " Jésus vient, t’enlèvera-t-il? : ",
            " En son nom qui nous rassemble ",
            " Triomphons, chantons d’allégresse ",
            " Suivez, suivez l’Agneau jusqu’au soir de la vie ",
            " Dieu prend-il plaisir à des offrandes  ",
            " Seigneur, à ton regard de flamme  ",
            " Les paroles de Christ sont très claires ",
            " Suis ton maitre, quand il te mène sur un obscur sentier  ",
            " Si tu veux être utile dans l’assemblée  ",
            " Lois et commandements, le Seigneur ",
            " Adieu, gloire et éclat du monde ",
            " Es-tu lassé, rempli de tristesse  ",
            " Veux-tu être pris lorsque Jésus viendra ",
            " Entends-tu ?  Jésus t’appelle  ",
            " Pourquoi donc  se mettre en peine  ",
            " Sois la bienvenue sur terre ",
            " Merci, o Dieu pour ce repas  ",
            " Avec gratitude et respect  ",
            " Dieu soit avec toi jusqu’au revoir ",
            " Oui du temps de Noé  ",
            " Comme il  est  bon de porter dans jeunesse ",
            " Nous voici tous devant Dieu. A nous l’avenir! ",
            " Non jamais je n’irais dans ce monde   ",
            " Je suis petit, mais que m’importe ?  ",
            " Jésus me demande d’être ",
            " Tout le temps bouillant, bouillant, oui bouillant  ",
            " Jeunesse écoute  le message  ",
            " Combat le bon combat de la foi ",
            " Cela te remplit-il de joie  ",
            " Tous rassemblés ",
            " O notre  Dieu, tu es notre consolateur ",
            " Guide, Jésus, mes pas dans la vie ",
            " Marcher dans la lumière donne paix et joie ",
            " Je sais une vie inconnue des hommes ",
            " Qu’il est bon de se rassembler ",
            " Tu peux servir Dieu, être un vase d’honneur ",
            " L’esprit agit  et le feu dévore ",
            " Quand je prie ma croit pour  marcher dans ta voie ",
            " Quelle grande grâce nous avons  ",
            " Vois-tu le royaume des cieux? ",
            " La croix parait une folie ",
            " Donne  à Jésus ta vie! ",
            " Disciple chez le maître je suis ",
            " C’est le temps de remercier et louer ",
            " Ne perds pas courage; Dieu t’aidera! ",
            " Guerre au péché, guerre à tout l’esclavage  ",
            " Il est une sainte guerre ",
            " Seigneur, ce que mon Cœur réclame ",
            " Dans la Bible je trouve une eau vive ",
            "Au pied de la sainte croix"
    };

}