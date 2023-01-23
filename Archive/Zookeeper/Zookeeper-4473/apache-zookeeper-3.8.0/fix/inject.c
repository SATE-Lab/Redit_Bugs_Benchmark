#include <stdio.h>
#include <stdlib.h>
// 定义ifdef的宏，后面可以改一改，比如改成#if
#define codeA 1
#define codeB 1
#define codeC 1
int main()
{
    FILE *fp1;
    FILE *fp2;
    int i = 0;
    char str[500]; // 读取文件的缓存区
    // 下面是修复代码
    char str1[7][200] =  {	"  <dependencies>\n",
    				"    <dependency>\n",
    				"      <groupId>org.mockito</groupId>\n",
    				"      <artifactId>mockito-core</artifactId>\n",
    				"      <scope>test</scope>\n",
    				"    </dependency>\n",
    				"  </dependencies>\n"};
    char str2[200]    = 	"import org.apache.zookeeper.inspector.logger.LoggerFactory;\n";
    char str3[6][200] =  {	"    private void showWarnDialog(String message){\n",
    				"        JOptionPane.showMessageDialog(this,\n",
    				"                message, \"Error\",\n",
    				"                JOptionPane.ERROR_MESSAGE);\n",
    				"    }\n",
    				"\n"};
    char str4[23][200] =  {	"                    boolean success;\n",
    				"                    try {\n",
    				"                        success = get();\n",
    				"                    } catch (Exception e) {\n",
    				"                        success = false;\n",
    				"                        LoggerFactory.getLogger().error(\"create fail for {} {}\", parentNode, newNodeName, e);\n",
    				"                        showWarnDialog(\"create \" + newNodeName + \" in \" + parentNode + \" fail, exception is \" + e.getMessage());\n",
    				"                    }\n",
    				"\n",
    				"                    if (!success) {\n",
    				"                        showWarnDialog(\"create \" + newNodeName + \" in \" + parentNode + \" fail, see log for more detail\");\n",
    				"                    }\n",
    				"                    else {\n",
    				"                        int i = 0;\n",
    				"                        for (; i < parentNode.getChildCount(); i++) {\n",
    				"                            ZooInspectorTreeNode existingChild = (ZooInspectorTreeNode) parentNode.getChildAt(i);\n",
    				"                            if (newNodeName.compareTo(existingChild.getName()) < 0) {\n",
    				"                                break;\n",
    				"                            }\n",
    				"                        }\n",
    				"                        insertNodeInto(new ZooInspectorTreeNode(newNodeName, parentNode, 0), parentNode, i);\n",
    				"                        parentNode.setNumDisplayChildren(parentNode.getNumDisplayChildren() + 1);\n",
    				"                    }\n"};
    char str5[200]    = 	"    DataEncryptionManager encryptionManager;\n";
    char str6[200]    = 	"    ZooKeeper zooKeeper;\n";
    char str7[7][200] =  {	"                    String node;\n",
    				"                    if (parent.endsWith(\"/\")) {\n",
    				"                        node = parent + nodeElement;\n",
    				"                    }\n",
    				"                    else {\n",
    				"                        node = parent + \"/\" + nodeElement;\n",
    				"                    }\n"};

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/pom.xml", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/pom.xml", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 82)
        {
            for (int j = 0; j < 7; j++)
            {
                fputs(str1[j], fp2);
            }
            fputs(str, fp2);
        }
        else
        {
            fputs(str, fp2);
        }
        i++; // 行号控制
    }
    i = 0;
    fclose(fp1);
    fclose(fp2);
    // 把修改完的文件传回去
    system("cp ./fixed/pom.xml ../zookeeper-contrib/zookeeper-contrib-zooinspector/");
    printf("create new pom.xml and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/pom.xml ../zookeeper-contrib/zookeeper-contrib-zooinspector/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/ZooInspectorTreeView.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/ZooInspectorTreeView.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 21)
        {
            fputs(str2, fp2);
            fputs(str, fp2);
        }
        else if (i == 357)
        {
            for (int j = 0; j < 6; j++)
            {
                fputs(str3[j], fp2);
            }
            fputs(str, fp2);
        }
        else if (i == 388)
        {
            for (int j = 0; j < 23; j++)
            {
                fputs(str4[j], fp2);
            }
        }
        else if (i == 389 || i == 390 || i == 391 || i == 392 || i == 393 || i == 394 || i == 395 || i == 396 || i == 397 || i == 398)
        {
        }
        else
        {
            fputs(str, fp2);
        }
        i++; // 行号控制
    }
    i = 0;
    fclose(fp1);
    fclose(fp2);
    // 把修改完的文件传回去
    system("cp ./fixed/ZooInspectorTreeView.java ../zookeeper-contrib/zookeeper-contrib-zooinspector/src/main/java/org/apache/zookeeper/inspector/gui/");
    printf("create new ZooInspectorTreeView.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/ZooInspectorTreeView.java ../zookeeper-contrib/zookeeper-contrib-zooinspector/src/main/java/org/apache/zookeeper/inspector/gui/");
    printf("use origin file ...\n");
#endif

#ifdef codeC
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/ZooInspectorManagerImpl.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/ZooInspectorManagerImpl.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 108)
        {
            fputs(str5, fp2);
        }
        else if (i == 111)
        {
            fputs(str6, fp2);
        }
        else if (i == 392)
        {
            for (int j = 0; j < 7; j++)
            {
                fputs(str7[j], fp2);
            }
        }
        else
        {
            fputs(str, fp2);
        }
        i++; // 行号控制
    }
    i = 0;
    fclose(fp1);
    fclose(fp2);
    // 把修改完的文件传回去
    system("cp ./fixed/ZooInspectorManagerImpl.java ../zookeeper-contrib/zookeeper-contrib-zooinspector/src/main/java/org/apache/zookeeper/inspector/manager/");
    printf("create new ZooInspectorManagerImpl.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/ZooInspectorManagerImpl.java ../zookeeper-contrib/zookeeper-contrib-zooinspector/src/main/java/org/apache/zookeeper/inspector/manager/");
    printf("use origin file ...\n");
#endif
}
