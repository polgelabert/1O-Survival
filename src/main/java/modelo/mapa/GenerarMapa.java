package modelo.mapa;

public class GenerarMapa {
    private int altura = 50, ample =100;
    private String [][] malla = new String[altura][ample];



    public String quinEdifici(int n, int nn)
    {
        String s= " ";
        switch (nn){
            case 1:
                switch (n){
                    case 1:
                        s="H";
                        break;
                    case 4:
                        s="O";
                        break;
                    case 7:
                        s="O";
                        break;
                }
                break;
            case 4:
                switch (n){
                    case 1:
                        s="O";
                        break;
                    case 4:
                        s= "E";
                        break;
                    case 7:
                        s="P";
                        break;
                }
                break;
            case 7:
                switch (n){
                    case 1:
                        s="C";
                        break;
                    case 4:
                        s="O";
                        break;
                    case 7:
                        s="O";
                        break;
                }
                break;

        }
        return s;
    }
    public void generateMapa()
    {
        boolean llocAlt = false, edifici = false;
        int n, nn=1,fin1, fin=3;

        for(int i = 0; i< altura; i++)
        {
            n=1; fin1=3;
            if (i == (nn*altura)/10) {
                llocAlt = true;
                nn +=3;
            } else if (i == (fin*altura)/10)
            {
                llocAlt = false;
                fin +=3;
            }
            for(int j = 0; j< ample; j++ )
            {
                if (j == (n*ample)/10 && llocAlt) {
                    edifici = true;
                    n +=3;
                } else if (j == (fin1*ample)/10)
                {
                    edifici = false;
                    fin1 +=3;
                }
                if(edifici) {
                    malla[i][j] = quinEdifici(n-3,nn-3);//"H";
                }else
                    malla[i][j] = "-";
            }

        }
        //malla[posX][posY] ="@";
    }
}
