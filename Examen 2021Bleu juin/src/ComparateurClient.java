import java.util.Comparator;
/**
 *
 * @author ABID Brahim
 *
 */
public class ComparateurClient implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {
        int priorite1 = client1.getPriorite();
        int priorite2 = client2.getPriorite();

        if (priorite1>priorite2)
            return -1;
        if (priorite1 == priorite2)
            return 0;
        return 1;

    }
}
