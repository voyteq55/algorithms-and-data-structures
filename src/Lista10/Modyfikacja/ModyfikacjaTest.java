package Lista10.Modyfikacja;

public class ModyfikacjaTest {
    public static void main(String[] args) {

        Child wojtek = new Child("wojtek");
        Child marek = new Child("marek");
        Child michal = new Child("michal");

        Child tomasz = new Child("tomasz");
        Child ola = new Child("ola");

        System.out.println(wojtek + " zna " + marek + ": " + wojtek.isFriendsWith(marek));

        wojtek.befriend(marek);
        System.out.println("\npo zaprzyjaznieniu wojtka i marka: ");

        System.out.println(wojtek + " zna " + marek + ": " + wojtek.isFriendsWith(marek));
        System.out.println(marek + " zna " + wojtek + ": " + marek.isFriendsWith(wojtek));

        System.out.println();
        System.out.println(marek + " zna " + michal + ": " + marek.isFriendsWith(michal));
        System.out.println(michal + " zna " + wojtek + ": " + michal.isFriendsWith(wojtek));

        wojtek.befriend(michal);
        System.out.println("\npo zaprzyjaznieniu wojtka i michala: ");
        System.out.println(michal + " zna " + marek + ": " + michal.isFriendsWith(marek));
        System.out.println(wojtek + " zna " + michal + ": " + wojtek.isFriendsWith(michal));

        ola.befriend(tomasz);
        System.out.println("\npo zaprzyjaznieniu oli i tomasza: ");
        System.out.println(ola + " zna " + tomasz + ": " + tomasz.isFriendsWith(ola));
        System.out.println(tomasz + " zna " + marek + ": " + tomasz.isFriendsWith(marek));
        System.out.println(michal + " zna " + ola + ": " + michal.isFriendsWith(ola));
        System.out.println(wojtek + " zna " + tomasz + ": " + wojtek.isFriendsWith(tomasz));
        System.out.println(michal + " zna " + marek + ": " + michal.isFriendsWith(marek));
    }
}
