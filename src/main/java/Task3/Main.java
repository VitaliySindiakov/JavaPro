package Task3;


public class Main {
    /*
    Создать проект «База данных заказов». Создать
таблицы «Товары» , «Клиенты» и «Заказы».
Написать код для добавления новых клиентов,
товаров и оформления заказов.
     */
    public static void main(String[] args) {
        CreateConnectionPreConditions createConnection = new CreateConnectionPreConditions();
        Operation operation = new Operation(createConnection.getConnection());
        operation.addToTable("goods","goodsName","price","bottle",5);
        operation.addToTable("clients","clientsName","age","Jack",30);
        operation.addToTable("orders","ordersName","orderID","bottleOrder",1);
    }
}
