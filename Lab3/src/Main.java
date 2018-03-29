import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream stream = new FileInputStream("res/Teams.csv");
        int length = stream.available();
        byte [] data = new byte[ length ];

        stream.read(data);
        stream.close();

        String text = new String(data);

        String results = "";

        String[] teams = text.split("\n");

            for ( int i = 0; i < teams.length; i++ ){

                String[] mat = teams[i].split(",");
                int res = 0;

                for ( int j = 1; j < mat.length; j++ ){

                    int a = mat[j].charAt(0) - 48;
                    int b = mat[j].charAt(2) - 48;

                    if ( a > b ) res += 3;
                    if ( a == b ) res += 1;

                }

                results += mat[0] + "," + res + "\n";
            }

        OutputStreamWriter stream1 = new OutputStreamWriter( new FileOutputStream("res/Results.csv") );

        stream1.write(results);
        stream1.close();
    }
}
