public class App {
    public static void main(String[] args) {
        Insect allInsects[] = new Insect[3];
        allInsects[0] = new Roach();
        allInsects[1] = new Beatle();
        allInsects[2] = new Spider();
        
                for (int i=0; i < allInsects.length; i++){
                    allInsects [i].eat();
                }
            }
        }
        
        
       