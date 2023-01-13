
public class JeuGuerrier {

    public static void main(String[] args) {
        EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
        int pointsDeVieDuMal = 30;

        // A COMPLETER
        while (pointsDeVieDuMal > 0 && equipe.nombreGuerriersEnVie() > 0) {

            System.out.println("L'equipe compte " + equipe.nombreGuerriersEnVie() + " guerriers en vie");

            int pointDegatGuerrier = lancerDe();
            int pointDegatDuMal = lancerDe();

            Guerrier guerrier = equipe.jouer(pointDegatDuMal);
            System.out.println("Suite au combat entre la creature du mal et le guerrier n°" + guerrier.getNumero());
            System.out.println("Le guerrier vient de perdre " + pointDegatDuMal + " points de vie");
            int pvGuerrier = guerrier.getPointsDeVie();
            pointsDeVieDuMal = pointsDeVieDuMal - pointDegatGuerrier;
            if (pointsDeVieDuMal< 0) {
                pointsDeVieDuMal = 0;
            }


            System.out.println("Il lui reste " + pvGuerrier + " points de vie");

            System.out.println("La creature du mal vient de perdre " + pointDegatGuerrier + " points de vie");
            System.out.println("Il reste "+ pointsDeVieDuMal + " points de vie à la creature du mal");

            if (pvGuerrier == 0) {
                System.out.println("Le guerrier est mort");
            }

            System.out.println();
        }
        if (pointsDeVieDuMal <= 0) {

            System.out.println("La creature du mal est morte");
        } else {

            System.out.println("Tous les guerriers sont morts");
        }
    }

    public static int lancerDe() {
        double nombreReel;
        nombreReel = Math.random();
        return (int) (nombreReel * 6) + 1;
    }

}
