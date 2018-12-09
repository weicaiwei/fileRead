package com.english;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ArrangeAndRead {
    //用来存放分割后的英文以及中文
    private List < EnglishAndChinese > list;

    /**
         * 整理传入的文件,整理后的内容放在list中
     * @param path
     */
    private void arrangeFile(String path) {
        list = new LinkedList < EnglishAndChinese > ();
        try {
            //缓存文件
            FileReader englishFile = new FileReader(path);
            BufferedReader read = new BufferedReader(englishFile);
            String line;

            //逐行读取，分割
            while ((line = read.readLine()) != null) {
                if (!"".equals(line)) {
                    EnglishAndChinese eac = new EnglishAndChinese();
                    StringBuilder englishBuilder = new StringBuilder();
                    StringBuilder chineseBuilder = new StringBuilder();
                    char[] lineChar = line.toCharArray();
                    int i = 0;
                    //抽出英文字母
                    for (char c: line.toCharArray()) {
                        if (!isChinese(c)) {
                            englishBuilder.append(c);
                            i++;
                        } else {
                            break;
                        }
                    }
                    //抽出汉字
                    for (int j = i; j < lineChar.length; j++) {
                        chineseBuilder.append(lineChar[j]);
                    }
                    //将汉字列的空格转换成顿号
                    String chinese = chineseBuilder.toString().replace(" ", "、");
                    String[] chineseArray = chinese.split("、");
                    //汉字去重
                    Set < String > chineseSet = new LinkedHashSet < String > ();
                    for (String s: chineseArray) {
                        chineseSet.add(s);
                    }
                    //清空字符串缓存
                    chineseBuilder.delete(0, chineseBuilder.length());
                    //重新插回到chineseBuilder
                    for (String s: chineseSet) {
                        chineseBuilder.append(s + "、");
                    }

                    eac.setEnglish(englishBuilder.toString());
                    eac.setChinese(chineseBuilder.toString());
                    list.add(eac);
                }

            }
            englishFile.close();
            read.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        for (EnglishAndChinese eac: list) {
            System.out.println(eac.toString());
        }
    }

    /**
         * 执行语句朗读
     * @param c
     * @return
     */
    public static void implementRead(String string) {
        // com.jacob.activeX包中的类
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo = sap.getObject();
        try {
            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(0));
            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(string));

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }
    /**
         * 执行文件朗读
     * @param c
     * @return
     */
    public void readFile(String path) {
        arrangeFile(path);
        while (true) {
            for (EnglishAndChinese eac: list) {

                try {
                    implementRead(eac.getEnglish());
                    Thread.sleep(300);
                    implementRead(eac.getChinese());
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
         * 判断是否是中文
     * @param c
     * @return
     */
    private boolean isChinese(char c) {

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS

        || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS

        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A

        || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION

        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION

        || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {

            return true;

        }

        return false;

    }
}