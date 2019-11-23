package top.haojianxiang.test;

import top.haojianxiang.entity.Sys_Topic;
import top.haojianxiang.service.Service;
import top.haojianxiang.service.ServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @Author 郝健祥
 * @Date 2019-11-18 18:42
 * @Description 界面
 * @Version 1.0
 */
public class InterFacee {
    //静态键盘扫描器
    static Scanner sc = new Scanner(System.in);

    static Service service = new ServiceImpl();

    //主界面
    public void interFace() {
        char choose = '\0';
        System.out.println("----------------------欢迎使用SXT贴吧----------------------");
        while (true) {
            System.out.println();
            System.out.println("----------- 贴吧·菜单 -------------");
            System.out.println("----------- 1. 查询帖子 -----------");
            System.out.println("----------- 2. 发表帖子 -----------");
            System.out.println("----------- 3. 查看帖子 -----------");
            System.out.print("-----请选择：");
            choose = sc.next().charAt(0);
            switch (choose) {
                case '1':  queryAll(); break;
                case '2':  create();   break;
                case '3':  view();     break;
                default:  System.out.println("输入不正确，请重新输入！");
            }
        }
    }

    /**
     * 查询帖子
     */
    private static void queryAll() {
        List<Sys_Topic> sys_topics = service.queryAll();
        for (Sys_Topic s : sys_topics) {
            System.out.println(s);
        }
    }

    /**
     * 发表帖子
     */
    private static void create() {
        int result = service.publish();
        System.out.println(result > 0 ? "发表成功！" : "发表失败");
    }

    /**
     * 查看帖子
     */
    private static void view() {
        System.out.print("请输入要查看的帖子的编号：");
        int topicId = sc.nextInt();
        Sys_Topic sysTopic = service.selectOne(topicId);
        System.out.println(sysTopic.toString_m());
        while (true){
            //二级菜单界面
            System.out.println();
            System.out.println("--------- 查看帖子·菜单 --------");
            System.out.println("--------- 1. 发表评论 ---------");
            System.out.println("--------- 2. 返回上级 ---------");
            System.out.print("-----请选择：");
            char choose = sc.next().charAt(0);
            if(choose=='2'){
                break;
            } else if(choose == '1'){
                service.publishReply(topicId);
            } else{
                continue;
            }
        }
    }

}
