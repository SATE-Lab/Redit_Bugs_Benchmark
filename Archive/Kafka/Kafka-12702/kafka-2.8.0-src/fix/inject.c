#include <stdio.h>
#include <stdlib.h>
// 定义ifdef的宏，后面可以改一改，比如改成#if
#define codeA 1
int main()
{
    FILE *fp1;
    FILE *fp2;
    int i = 0;
    char str[500]; // 读取文件的缓存区
    // 下面是修复代码
    char str1[200]    = 	"import java.net.InetAddress\n";
    char str2[200]    = 	"          setHost(if (ep.host == null || ep.host.trim.isEmpty) InetAddress.getLocalHost.getCanonicalHostName else ep.host).\n";

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/BrokerServer.scala", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/BrokerServer.scala", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 23)
        {
            fputs(str1, fp2);
            fputs(str, fp2);
        }
        else if (i == 274)
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
    system("cp ./fixed/BrokerServer.scala ../core/src/main/scala/kafka/server/");
    printf("create new BrokerServer.scala and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/BrokerServer.scala ../core/src/main/scala/kafka/server/");
    printf("use origin file ...\n");
#endif
}
