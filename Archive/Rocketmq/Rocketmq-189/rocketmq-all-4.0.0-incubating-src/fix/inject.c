#include <stdio.h>
#include <stdlib.h>
// 定义ifdef的宏，后面可以改一改，比如改成#if
//#define codeA 1
//#define codeB 1
//#define codeC 1
int main()
{
    FILE *fp1;
    FILE *fp2;
    int i = 0;
    char str[500]; // 读取文件的缓存区
    // 下面是修复代码
    char str1[200]    = 	"        Date dt = UtilAll.parseDate(this.defaultMQPushConsumer.getConsumeTimestamp(), UtilAll.YYYYMMDDHHMMSS);\n";
    char str2[3][200] = {	"                \"consumeTimestamp is invalid, the valid format is yyyyMMddHHmmss,but received \"\n",
    				"                    + this.defaultMQPushConsumer.getConsumeTimestamp()\n",
    				"                    + \" \" + FAQUrl.suggestTodo(FAQUrl.CLIENT_PARAMETER_CHECK_URL), null);\n"};
    char str3[200]    = 	"                                UtilAll.YYYYMMDDHHMMSS).getTime();\n";
    char str4[200]    = 	"    public static final String YYYYMMDDHHMMSS = \"yyyyMMddHHmmss\";\n";

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/DefaultMQPushConsumerImpl.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/DefaultMQPushConsumerImpl.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 656)
        {
            fputs(str1, fp2);
        }
        else if (i == 659)
        {
            for (int j = 0; j < 3; j++)
            {
                fputs(str2[j], fp2);
            }
        }
        else if (i == 660 || i == 661)
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
    system("cp ./fixed/DefaultMQPushConsumerImpl.java ../client/src/main/java/org/apache/rocketmq/client/impl/consumer/");
    printf("create new DefaultMQPushConsumerImpl.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/DefaultMQPushConsumerImpl.java ../client/src/main/java/org/apache/rocketmq/client/impl/consumer/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/RebalancePushImpl.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/RebalancePushImpl.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 162)
        {
            fputs(str3, fp2);
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
    system("cp ./fixed/RebalancePushImpl.java ../client/src/main/java/org/apache/rocketmq/client/impl/consumer/");
    printf("create new RebalancePushImpl.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/RebalancePushImpl.java ../client/src/main/java/org/apache/rocketmq/client/impl/consumer/");
    printf("use origin file ...\n");
#endif

#ifdef codeC
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/UtilAll.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/UtilAll.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 43)
        {
            fputs(str4, fp2);
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
    system("cp ./fixed/UtilAll.java ../common/src/main/java/org/apache/rocketmq/common/");
    printf("create new UtilAll.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/UtilAll.java ../common/src/main/java/org/apache/rocketmq/common/");
    printf("use origin file ...\n");
#endif
}
