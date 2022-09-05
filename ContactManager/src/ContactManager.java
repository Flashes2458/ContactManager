
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {                      //主程序
        Directory myContacts = new Directory();
        myContacts.showMenu();                                    //显示主菜单
        Scanner input = new Scanner(System.in);
        int funcNum = input.nextInt();
        while (funcNum!=0) {
            switch (funcNum) {                                   //选择菜单对应的功能
                case 1 -> myContacts.addContact(myContacts);
                case 2 -> myContacts.showContacts(myContacts);
                case 3 -> myContacts.deleteContact(myContacts);
                case 4 -> myContacts.findContact(myContacts);
                case 5 -> myContacts.modifyContact(myContacts);
                case 6 -> myContacts.freeAllContacts(myContacts);
                default -> {
                    System.out.println("错误的输入");
                    try {
                        System.in.read();
                    }
                    catch (Exception e){}
                }

            }
            myContacts.showMenu();
            funcNum = input.nextInt();
        }
    }

    static class Contact {                                         //Contact类，用来存储联系人信息
        String name;
        int sex;
        int age;
        String phoneNumber;
        String address;

        public Contact(String nm, int sex, int age, String phNub, String adr) {
            name = nm;
            this.sex = sex;
            this.age = age;
            phoneNumber = phNub;
            address = adr;
        }
    }

    static class Directory {                                        //Deirectory类，产生联系人电话簿，定义各个方法
        ArrayList<Contact> array = new ArrayList<Contact>();

        public void showMenu() {
                System.out.println("**********************"+
                "\n"+"****"+"  1.添加联系人  "+"****"+"\n"+"****"+"  2.显示联系人  "+"****"+"\n"+"****"+"  3.删除联系人  "+"****"+"\n"+"****"+"  4.查找联系人  "+"****"+"\n"+"****"+"  5.修改联系人  "+"****"+"\n"+"****"+"  6.清空联系人  "+"****"+"\n"+"****"+"  0.退出       "+"****"+"\n"
                +"**********************"+"\n");
            System.out.println("请输入功能对应的数字(0~6)：");
    }

        public void addContact(Directory book){
            Scanner input = new Scanner(System.in);
            System.out.print("输入姓名：");
            String name = input.next();
            System.out.print("请输入性别：");
            int sex = input.nextInt();
            System.out.print("请输入年龄：");
            int age = input.nextInt();
            System.out.print("请输入电话号码：");
            String phonenumber = input.next();
            System.out.print("请输入家庭地址：");
            String address = input.next();
            book.array.add(new Contact(name,sex,age,phonenumber,address));
            System.out.println("添加成功,按回车(Enter)键继续");
            try {
                System.in.read();
            }
            catch (Exception e){}
        }

        public void showContacts(Directory book){
            for(int i=0;i<book.array.size();++i){
                System.out.println(i+1 + " .姓名：" + book.array.get(i).name + "\t"
                        + "  性别：" + (book.array.get(i).sex== 1 ? "男" : "女") + "\t"
                        + "  年龄：" + book.array.get(i).age + "\t"
                        + "  手机号:" + book.array.get(i).phoneNumber + "\t"
                        + "  家庭住址:" + book.array.get(i).address + "\t");
            }
            System.out.println("显示完毕,按回车(Enter)键继续");
            try {
                System.in.read();
            }
            catch (Exception e){}
        }

        public void deleteContact(Directory book){
            Scanner input = new Scanner(System.in);
            System.out.println("请输入你想删除的联系人的名字：");
            String name1 = input.next();
            int i=0;
            boolean flag = false;
            for(;i<book.array.size();++i)
                if(book.array.get(i).name.equals(name1)) {
                    book.array.remove(i--);
                    System.out.println("删除成功，按回车(Enter)键继续");
                    flag = true;
                }
            if(flag == false)
                System.out.println("删除失败：没有查找到该姓名，按回车(Enter)键继续");

            try {
                System.in.read();
            }
            catch (Exception e){}
        }

        public void findContact(Directory book){
            Scanner input = new Scanner(System.in);
            System.out.println("请输入你想查找的联系人的名字：");
            String name2 = input.next();
            int i=0;
            boolean flag = false;
            for(;i<book.array.size();++i)
                if(book.array.get(i).name.equals(name2)) {
                    if(flag == false)
                        System.out.println("查找成功");
                    flag = true;
                    System.out.println(" 姓名：" + book.array.get(i).name + "\t"
                            + "  性别：" + (book.array.get(i).sex == 1 ? "男" : "女") + "\t"
                            + "  年龄：" + book.array.get(i).age + "\t"
                            + "  手机号:" + book.array.get(i).phoneNumber + "\t"
                            + "  家庭住址:" + book.array.get(i).address + "\t");
                }
            if(flag == true)
                System.out.println("按回车(Enter)键继续");
            if(flag == false)
                System.out.println("没有查找到该姓名，按回车(Enter)键继续");
            try {
                System.in.read();
            }
            catch (Exception e){}
        }

        public void modifyContact(Directory book){
            Scanner input = new Scanner(System.in);
            System.out.println("请输入你想修改的联系人的名字：");
            String name3 = input.next();
            int i=0;
            boolean flag = false;
            for(;i<book.array.size();++i)
                if(book.array.get(i).name.equals(name3)) {
                    System.out.println("查找到"+name3+"，修改为：");
                    flag = true;
                    System.out.print(" 姓名：");
                    book.array.get(i).name = input.next();
                    System.out.print(" 性别：");
                    book.array.get(i).sex = input.nextInt();
                    System.out.print(" 年龄：");
                    book.array.get(i).age = input.nextInt();
                    System.out.print(" 手机号：");
                    book.array.get(i).phoneNumber = input.next();
                    System.out.print(" 家庭住址：");
                    book.array.get(i).address = input.next();
                    System.out.println("修改成功，按回车(Enter)键继续");
                }
            if(i>array.size())
                System.out.print("没有查找到该姓名，按回车(Enter)键继续");
            try {
                System.in.read();
            }
            catch (Exception e){}

        }

        public void freeAllContacts(Directory book){
            for(int i=0;i<book.array.size();)
                book.array.remove(i);
            System.out.println("删除成功，按回车(Enter)键继续");
            try {
                System.in.read();
            }
            catch (Exception e){}
        }
    }
}
