import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparator {

	public void ordenarMateriasPorPesoCrescente() {
        Collections.sort(materias, new ComparadorCrescente());
    }

    public void ordenarMateriasPorPesoDecrescente() {
        Collections.sort(materias, new ComparadorDecrescente());
    }

    private class ComparadorCrescente implements Comparator<Materia> {

        @Override
        public int compare(Materia o1, Materia o2) {
            int peso1 = 0;
            int peso2 = 0;
            try {
                peso1 = Integer.parseInt(o1.peso);
                peso2 = Integer.parseInt(o2.peso);
            } catch (NumberFormatException e) {
                ;
            }
            return (peso1 < peso2) ? -1 : ((peso1 > peso2) ? 1 : 0);
        }
    }

    private class ComparadorDecrescente implements Comparator<Materia> {

        @Override
        public int compare(Materia o1, Materia o2) {
            int peso1 = 0;
            int peso2 = 0;
            try {
                peso1 = Integer.parseInt(o1.peso);
                peso2 = Integer.parseInt(o2.peso);
            } catch (NumberFormatException e) {
                ;
            }
            return (peso1 < peso2) ? 1 : ((peso1 > peso2) ? -1 : 0);
        }
    }

}
