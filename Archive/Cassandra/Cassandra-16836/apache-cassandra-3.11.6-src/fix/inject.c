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
    char str1[200] = "            return name.toCQLString() + terms.stream().map(Term.Raw::getText).collect(Collectors.joining(\", \", \"(\", \")\"));\n";
    char str2[200] = "import org.apache.cassandra.cql3.ColumnIdentifier;\n";
    char str3[3][200] = {	"    // We special case the token function because that's the only function which name is a reserved keyword\n",
    			  	"    private static final FunctionName TOKEN_FUNCTION_NAME = FunctionName.nativeFunction(\"token\");\n",
				"\n"};
    char str4[10][200] = {	"\n",
    				"    public String toCQLString()\n",
                         	"    {\n",
                         	"        String maybeQuotedName = equalsNativeFunction(TOKEN_FUNCTION_NAME)\n",
                         	"               ? name\n",
                         	"               : ColumnIdentifier.maybeQuote(name);\n",
                         	"        return keyspace == null\n",
                         	"               ? maybeQuotedName\n",
                         	"               : ColumnIdentifier.maybeQuote(keyspace) + '.' + maybeQuotedName;\n",
                         	"    }\n"};

#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/FunctionCall.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/FunctionCall.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 206)
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
    system("cp ./fixed/FunctionCall.java ../src/java/org/apache/cassandra/cql3/functions/");
    printf("create new FunctionCall.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/FunctionCall.java ../src/java/org/apache/cassandra/cql3/functions/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    fp1 = fopen("./origin/FunctionName.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/FunctionName.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
    	if (i == 22)
    	{
            fputs(str2, fp2);
            fputs(str, fp2);
    	}
        else if (i == 25)
        {
            for (int j = 0; j < 3; j++)
            {
                fputs(str3[j], fp2);
            }
            fputs(str, fp2);
        }
        else if (i == 81)
        {
            for (int j = 0; j < 10; j++)
            {
                fputs(str4[j], fp2);
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
    system("cp ./fixed/FunctionName.java ../src/java/org/apache/cassandra/cql3/functions/");
    printf("create new FunctionName.java and cp ...\n");
#else
    system("cp ./origin/FunctionName.java ../src/java/org/apache/cassandra/cql3/functions/");
    printf("use origin file ...\n");
#endif
}
