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
    char str1[4][200] = {	"            if (bytes.remaining() == 0)\n",
    			  	"            {\n",
				"                return;\n",
				"            }\n"};
    char str2[200] = "            throw new MarshalException(\"Not enough bytes to read a map\");\n";
    char str3[4][200] = {	"            if (bytes.remaining() == 0)\n",
    				"            {\n",
                         	"                return;\n",
                         	"            }\n"};

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/MapSerializer.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/MapSerializer.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 74)
        {
            for (int j = 0; j < 4; j++)
            {
                fputs(str1[j], fp2);
            }
            fputs(str, fp2);
        }
        else if (i == 86)
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
    system("cp ./fixed/MapSerializer.java ../src/java/org/apache/cassandra/serializers/");
    printf("create new MapSerializer.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/MapSerializer.java ../src/java/org/apache/cassandra/serializers/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    fp1 = fopen("./origin/SetSerializer.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/SetSerializer.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 64)
        {
            for (int j = 0; j < 4; j++)
            {
                fputs(str3[j], fp2);
            }
            fputs(str, fp2);
        }
        else
        {
            fputs(str, fp2);
        }
        i++;
    }
    i = 0;
    fclose(fp1);
    fclose(fp2);
    system("cp ./fixed/SetSerializer.java ../src/java/org/apache/cassandra/serializers/");
    printf("create new SetSerializer.java and cp ...\n");
#else
    system("cp ./origin/SetSerializer.java ../src/java/org/apache/cassandra/serializers/");
    printf("use origin file ...\n");
#endif
}
