package tarefa06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 *
 * @author Elaine
 */
class ArrayListThreadSafe {

    ReadWriteLock rwl;
    Lock r;
    Lock w;

    ArrayListThreadSafe(ReadWriteLock rwl) {
        this.rwl = rwl;

        r = this.rwl.readLock();
        w = this.rwl.writeLock();
    }

    public void read() {
        r.lock();

        try {

            System.out.println("Reading...");
            Thread.sleep(2000);
            System.out.println("Reading finish");

        } catch (Exception ex) {
            System.out.println("Err read: " + ex);
        } finally {
            r.unlock();
        }
    }

    public void write() {
        w.lock();

        try {

            System.out.println("wrinting...");
            Thread.sleep(5000);
            System.out.println("writing finish");

        } catch (Exception ex) {
            System.out.println("Err write: " + ex);
        } finally {
            w.unlock();
        }
    }
}
