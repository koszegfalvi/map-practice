import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> ovodaiJelek = new HashMap<>();
        ovodaiJelek.put("Zámbó Jimmy", "korona");
        ovodaiJelek.put("Zámbó Árpi", "hajkorona");
        ovodaiJelek.put("Gábor", "fenyőfa");
        ovodaiJelek.put("András", "fenyőfa");
        ovodaiJelek.put("András", "ház");

        System.out.println(ovodaiJelek.toString());
        ovodaiJelek.remove("Zámbó Árpi");
        System.out.println(ovodaiJelek.get("Gábor"));
        System.out.println(ovodaiJelek.keySet());
        System.out.println(ovodaiJelek.values());
        System.out.println(ovodaiJelek.entrySet());
        System.out.println(ovodaiJelek.get("Lajos"));
        ovodaiJelek.replace("Gábor", "fenyőfa", "labda");
        System.out.println(ovodaiJelek);

        Map<String, Integer> heightMap = new HashMap<>();
        heightMap.put("Sziproka", 131);
        heightMap.put("Csuporka", 134);
        heightMap.put("Puszedli", 123);
        heightMap.put("X-Professzor", 185);
        heightMap.put("Mohó Jojó", 152);
        System.out.println(heightMap.values());

        int max = Integer.MIN_VALUE;


        for (Integer actual : heightMap.values()) {
            if (actual > max) {
                max = actual;
            }
        }

        System.out.println(max);

        for (var actual : heightMap.entrySet()
        ) {
            if (max == actual.getValue()) {
                System.out.println(actual.getKey());
            }
        }
        String nev;
        for (Map.Entry<String, Integer> actual : heightMap.entrySet()) {

        }
        int min = Integer.MAX_VALUE;


        for (Integer actual : heightMap.values()) {
            if (actual < min) {
                min = actual;
            }
        }

        System.out.println(min);

        for (var actual : heightMap.entrySet()
        ) {
            if (min == actual.getValue()) {
                System.out.println(actual.getKey());
            }
        }
        /*int min = Integer.MAX_VALUE;
        Map.Entry<String,Integer> minEntry = null;

        for (var actual : heightMap.entrySet()) {
            if (actual.getValue() < min) {
                min = actual.getValue();
                minEntry = actual;
            }
        }
        System.out.println(minEntry.getKey());*/
        heightMap.replace("Sziporka", heightMap.get("Sziporka") + 1);
        System.out.println();

        List<Integer> aliceGrades = new ArrayList<>();
        Map<String,List<Integer>>grades=new HashMap<>();
        grades.put("Alice", Arrays.asList(5, 2, 1));
        grades.put("Bob", Arrays.asList(4, 3));
        grades.put("Charlie",Arrays.asList(1,1,1,1,1));
    }
}
