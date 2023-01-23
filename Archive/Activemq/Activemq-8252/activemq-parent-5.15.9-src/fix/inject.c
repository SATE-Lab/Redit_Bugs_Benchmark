#include <stdio.h>
#include <stdlib.h>
// 定义ifdef的宏，后面可以改一改，比如改成#if
//#define codeA 1
//#define codeB 1
int main()
{
    FILE *fp1;
    FILE *fp2;
    int i = 0;
    char str[500]; // 读取文件的缓存区
    // 下面是修复代码
    char str1[200]    = 	"            throw new SecurityException(\"User name [\" + username + \"] or password is invalid.\");\n";
    char str2[200]    = 	"            LOG.warn(\"Failed to add Connection id={}, clientId={}, clientIP={} due to {}\", info.getConnectionId(), clientId, info.getClientIp(), e.getLocalizedMessage());\n";

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/JaasAuthenticationBroker.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/JaasAuthenticationBroker.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 96)
        {
            fputs(str1, fp2);
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
    system("cp ./fixed/JaasAuthenticationBroker.java ../activemq-broker/src/main/java/org/apache/activemq/security/");
    printf("create new JaasAuthenticationBroker.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/JaasAuthenticationBroker.java ../activemq-broker/src/main/java/org/apache/activemq/security/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/TransportConnection.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/TransportConnection.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 854)
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
    system("cp ./fixed/TransportConnection.java ../activemq-broker/src/main/java/org/apache/activemq/broker/");
    printf("create new TransportConnection.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/TransportConnection.java ../activemq-broker/src/main/java/org/apache/activemq/broker/");
    printf("use origin file ...\n");
#endif
}
