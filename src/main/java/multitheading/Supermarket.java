package multitheading;

import java.util.LinkedList;

public class Supermarket {
    public static void main(String[] args)
            throws InterruptedException
    {
        // обработчик для всех тредов: потребитель, производитель и условный магазин
        final allThreads allThreads = new allThreads();

        // Создать тред для производителя
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    allThreads.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Создать тред для потребителя
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    allThreads.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Создать тред для магазина - оповещателя об оставшихся товарах

        Thread shopThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    allThreads.buy();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Выполняются все три треда
        producerThread.start();
        consumerThread.start();
        shopThread.start();

        // Последовательность выполнения тредов

        producerThread.join();
        shopThread.join();
        consumerThread.join();

    }

    // Создаем список, производитель добавляет объект, потребитель удаляет
    public static class allThreads {

        // Создать список, распределенный между тредами
        // Размер списка равен трем
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int capacity = 5;

        // Вызов треда производителя
        public void produce() throws InterruptedException
        {
            int value = 0;
            while (true) {
                synchronized (this)
                {
                    // Производитель ждет, когда заполнится его тред
                    while (list.size() == capacity)
                        wait();

                    System.out.println("Пекарня произвела хлеба: "
                            + value);

                    // вставляем параметры в список
                    list.add(value++);
                    // System.out.println("Осталось: "  + value);

                    // сообщить потребителю, что можно забирать данные
                    notifyAll();

                    // задержка
                    Thread.sleep(1000);
                }
            }
        }

        public void buy() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {

                    while (list.size() == 0)
                        wait();

                    list2.add(value++);
                    list.removeFirst();
                    System.out.println("Осталось: "  + list2.size());

                    notifyAll();


                    Thread.sleep(1000);
                }
            }
        }

        // Вызов треда потребителя (поступление в магазин)
        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    // Потребитель ждет, пока список пуст
                    while (list2.size() == 0)
                        wait();

                    // Вытягиваем первое значение из списка

                    int value = list2.removeFirst();

                    System.out.println("Потребитель купил: "
                            + value);

                    // Будим тред производителя
                    notifyAll();

                    // Засыпаем
                    Thread.sleep(1000);
                }
            }
        }

    }
}

