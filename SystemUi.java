
package GroupC;

import java.io.IOException;
import java.util.Scanner;

import Create.Register;
import Delete.Delete;
import Update.FileChange;

public class SystemUi {
    

    public static String FILEPATH = ".\\ProductManagement_Java_0049_C.csv";

    SystemUi() {
        java.io.File file = new java.io.File(FILEPATH);
        System.out.println(file.exists());
        if (!file.exists()) {
            try {
                System.out.println("ファイルが存在しないため新しいファイルを作成しました。");
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static void start_System() {
        while (true) {
            System.out.println("メニュー番号を入力してください。");
            System.out.print("[メニュー] 1:検索 2:登録 3:変更 4:削除 0:終了 > ");
            select_printDelete_Menu();
        }
    }

    private static void select_printDelete_Menu() {
        
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()) {
            case "1": //Search 
                System.out.println("---------------------------");
                System.out.println("検索メニューへ移動します。");
                System.out.println("---------------------------");
                Method1.searchMain();
                break;
            case "2": //Add 
                System.out.println("---------------------------");
                System.out.println("登録メニューへ移動します。");
                System.out.println("---------------------------");
                Register.register();
                break;
            case "3": //Change 
                System.out.println("---------------------------");
                System.out.println("変更メニューへ移動します。");
                System.out.println("---------------------------");
                FileChange fileChange = new FileChange(SystemUi.FILEPATH, "Shift_JIS");
                fileChange.change();
                break;
            case "4": //Delete 
                System.out.println("---------------------------");
                System.out.println("削除メニューへ移動します。");
                System.out.println("---------------------------");
                Delete.delete();
                break;
            case "0": //Exit 
                System.out.println("---------------------------");
                System.out.println("システムを終了します。");
                System.out.println("---------------------------");
                System.exit(0); 
                break;
            default:
                System.out.println("---------------------------");
                System.out.println("メニュー番号が間違っています。正しい値を入力してください。");
                System.out.println("---------------------------");

        }
    }
}