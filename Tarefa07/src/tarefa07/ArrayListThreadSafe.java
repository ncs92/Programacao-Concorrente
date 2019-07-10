/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 *
 * @author Elaine
 */
public class ArrayListThreadSafe {

    ReadWriteLock rwl;
    Lock read;
    Lock write;

    ArrayListThreadSafe(ReadWriteLock rwl) {
        this.rwl = rwl;
        read = this.rwl.readLock();
        write = this.rwl.writeLock();
    }

    public void read() {
        read.lock();
        try {
            System.out.println("Reading...");
            Thread.sleep(2000);
            System.out.println("Reading finish!");
        } catch (Exception ex) {
            System.out.println("Error read: " + ex);
        } finally {
            read.unlock();
        }
    }

    public void write() {
        write.lock();
        try {
            System.out.println("Writing...");
            Thread.sleep(5000);
            System.out.println("Writing finish");
        } catch (Exception ex) {
            System.out.println("Error write: " + ex);
        } finally {
            write.unlock();
        }
    }
}
