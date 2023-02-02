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
    char str1[200]    = 	"      \"A value of '*' indicates ACL should apply to all topics.\")\n";
    char str2[200]    = 	"      \"A value of '*' indicates the ACLs should apply to all groups.\")\n";
    char str3[200]    = 	"      \"be added or removed. A value of '*' indicates the ACLs should apply to all transactionalIds.\")\n";
    char str4[200]    = 	"      \"A value of '*' indicates ACL should apply to all tokens.\")\n";
    char str5[200]    = 	"      \" For example, User:'*' is the wild card indicating all users.\")\n";
    char str6[200]    = 	"      \"allows access to User:'*' and specify --deny-principal=User:test@EXAMPLE.COM. \" +\n";
    char str7[200]    = 	"      \"If you have specified --allow-principal then the default for this option will be set to '*' which allows access from all hosts.\")\n";
    char str8[200]    = 	"      \"If you have specified --deny-principal then the default for this option will be set to '*' which denies access from all hosts.\")\n";

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/AclCommand.scala", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/AclCommand.scala", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 520)
        {
            fputs(str1, fp2);
        }
        else if (i == 527)
        {
            fputs(str2, fp2);
        }
        else if (i == 533)
        {
            fputs(str3, fp2);
        }
        else if (i == 543)
        {
            fputs(str4, fp2);
        }
        else if (i == 571)
        {
            fputs(str5, fp2);
        }
        else if (i == 581)
        {
            fputs(str6, fp2);
        }
        else if (i == 594)
        {
            fputs(str7, fp2);
        }
        else if (i == 600)
        {
            fputs(str8, fp2);
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
    system("cp ./fixed/AclCommand.scala ../core/src/main/scala/kafka/admin/");
    printf("create new AclCommand.scala and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/AclCommand.scala ../core/src/main/scala/kafka/admin/");
    printf("use origin file ...\n");
#endif
}
