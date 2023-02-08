#include <stdio.h>
#include <stdlib.h>
// 定义ifdef的宏，后面可以改一改，比如改成#if
#define codeA 1
#define codeB 1
int main()
{
    FILE *fp1;
    FILE *fp2;
    int i = 0;
    char str[500]; // 读取文件的缓存区
    // 下面是修复代码
    char str1[7][200] = {	"                    // name server address and web server address should be specified at least one\n",
    				"                    if (null == this.clientConfig.getNamesrvAddr() && MixAll.getWSAddr().equals(MixAll.WS_ADDR)) {\n",
    				"                        throw new MQClientException(\"name server address and web server address should be specified at least one.\", null);\n",
    				"                    } else if (null == this.clientConfig.getNamesrvAddr()) {\n",
    				"                        this.mQClientAPIImpl.fetchNameServerAddr();\n",
    				"                    }\n",
    				"\n"};
    char str2[200]    = 	"    public static final String WS_ADDR = \"http://\" + WS_DOMAIN_NAME + \":8080/rocketmq/\" + WS_DOMAIN_SUBGROUP;\n";

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/MQClientInstance.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/MQClientInstance.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 227)
        {
            for (int j = 0; j < 7; j++)
            {
                fputs(str1[j], fp2);
            }
        }
        else if (i == 228 || i == 229 || i == 230)
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
    system("cp ./fixed/MQClientInstance.java ../client/src/main/java/org/apache/rocketmq/client/impl/factory/");
    printf("create new MQClientInstance.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/MQClientInstance.java ../client/src/main/java/org/apache/rocketmq/client/impl/factory/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/MixAll.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/MixAll.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 57)
        {
        }
        else if (i == 58)
        {
            fputs(str2, fp2);
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
    system("cp ./fixed/MixAll.java ../common/src/main/java/org/apache/rocketmq/common/");
    printf("create new MixAll.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/MixAll.java ../common/src/main/java/org/apache/rocketmq/common/");
    printf("use origin file ...\n");
#endif
}
