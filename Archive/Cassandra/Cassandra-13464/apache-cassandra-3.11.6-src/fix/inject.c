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
    char str1[200] = "import org.apache.cassandra.exceptions.InvalidRequestException;\n";
    char str2[10][200] = {	"    public boolean containsTokenRelations()\n",
    			  	"    {\n",
				"        for (Relation rel : relations)\n",
				"        {\n",
				"            if (rel.onToken())\n",
				"                return true;\n",
				"        }\n",
				"        return false;\n",
				"    }\n",
				"\n"};
    char str3[3][200] = {	"        if (whereClause.containsTokenRelations())\n",
                         	"            throw new InvalidRequestException(\"Cannot use token relation when defining a materialized view\");\n",
                         	"\n"};

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/WhereClause.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/WhereClause.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 26)
        {
            fputs(str1, fp2);
            fputs(str, fp2);
        }
        else if (i == 59)
        {
            fputs(str, fp2);
            for (int j = 0; j < 10; j++)
            {
                fputs(str2[j], fp2);
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
    system("cp ./fixed/WhereClause.java ../src/java/org/apache/cassandra/cql3/");
    printf("create new WhereClause.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/WhereClause.java ../src/java/org/apache/cassandra/cql3/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    fp1 = fopen("./origin/CreateViewStatement.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/CreateViewStatement.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 241)
        {
            for (int j = 0; j < 3; j++)
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
    system("cp ./fixed/CreateViewStatement.java ../src/java/org/apache/cassandra/cql3/statements/");
    printf("create new CreateViewStatement.java and cp ...\n");
#else
    system("cp ./origin/CreateViewStatement.java ../src/java/org/apache/cassandra/cql3/statements/");
    printf("use origin file ...\n");
#endif
}
