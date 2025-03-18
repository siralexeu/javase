public class ProgramVector {
    static void afisare(int[] vector, String mesaj){
        System.out.print(mesaj + ": ");
        for(var element:vector){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void incrementare(int[] vector){
        for(var i = 0; i < vector.length; i++){
            vector[i]++;
        }
    }
    static int[] inserare(int[] vector, int valoare){
        var temp=new int[vector.length + 1];
        temp[0] = valoare;
        for(var i=0; i<vector.length; i++){
            temp[i+1] = vector[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        var vSiruri =  args[0].split(",");
        var v = new int[vSiruri.length];

        for(var i=0;i<vSiruri.length;i++){
            v[i]=Integer.parseInt(vSiruri[i]);
        }
        afisare(v,"initial");
        incrementare(v);
        afisare(v,"dupa incrementare");
        v=inserare(v,15);
        afisare(v,"dupa inserare");
    }
}
