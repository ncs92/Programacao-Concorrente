package tarefa06;

/**
 *
 * @author Elaine
 */
class Reader extends Thread {

    ArrayListThreadSafe array;

    Reader(ArrayListThreadSafe array) {
        this.array = array;
    }

    @Override
    public void run() {
        while(true) {
            array.read();
        }
    }
}
