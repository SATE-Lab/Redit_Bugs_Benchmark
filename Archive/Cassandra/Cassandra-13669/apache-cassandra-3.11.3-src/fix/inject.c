#include <stdio.h>
#include <stdlib.h>
// 定义ifdef的宏，后面可以改一改，比如改成#if
#define codeA 1
#define codeB 1
#define codeC 1
#define codeD 1
#define codeE 1
#define codeF 1
#define codeG 1
int main()
{
    FILE *fp1;
    FILE *fp2;
    int i = 0;
    char str[500]; // 读取文件的缓存区
    // 下面是修复代码
    char str1[200] = 		"        IndexMode.validateAnalyzer(options, target.left);\n";
    char str2[200] = 		"    public abstract boolean isCompatibleWith(AbstractType<?> validator);\n";
    char str3[5][200] = {	"    @Override\n",
    			  	"    public boolean isCompatibleWith(AbstractType<?> validator)\n",
				"    {\n",
				"        return VALID_ANALYZABLE_TYPES.containsKey(validator);\n",
				"    }\n"};
    char str4[5][200] = {	"    @Override\n",
    				"    public boolean isCompatibleWith(AbstractType<?> validator)\n",
                         	"    {\n",
                         	"        return true;\n",
                         	"    }\n"};
    char str5[5][200] = {	"    @Override\n",
    				"    public boolean isCompatibleWith(AbstractType<?> validator)\n",
                         	"    {\n",
                         	"        return VALID_ANALYZABLE_TYPES.contains(validator);\n",
                         	"    }\n"};
    char str6[200] = 		"import java.util.HashSet;\n";
    char str7[200] = 		"import java.util.Set;\n";  
    char str8[200] = 		"import org.apache.cassandra.db.marshal.AsciiType;\n";
    char str9[7][200] = {	"    private static final Set<AbstractType<?>> VALID_ANALYZABLE_TYPES = new HashSet<AbstractType<?>>()\n",
    				"    {\n",
                         	"        {\n",
                         	"            add(UTF8Type.instance);\n",
                         	"            add(AsciiType.instance);\n",
                         	"        }\n",
                         	"    };\n"};
    char str10[5][200] = {	"    @Override\n",
    				"    public boolean isCompatibleWith(AbstractType<?> validator)\n",
                         	"    {\n",
                         	"        return VALID_ANALYZABLE_TYPES.contains(validator);\n",
                         	"    }\n"};
    char str11[200] = 		"    public static void validateAnalyzer(Map<String, String> indexOptions, ColumnDefinition cd) throws ConfigurationException\n";
    char str12[200] = 		"            Class<?> analyzerClass;\n";
    char str13[200] = 		"                analyzerClass = Class.forName(indexOptions.get(INDEX_ANALYZER_CLASS_OPTION));\n";
    char str14[14][200] = {	"            AbstractAnalyzer analyzer;\n",
    				"            try\n",
                         	"            {\n",
                         	"                analyzer = (AbstractAnalyzer) analyzerClass.newInstance();\n",
                         	"                if (!analyzer.isCompatibleWith(cd.type))\n",
                         	"                    throw new ConfigurationException(String.format(\"%s does not support type %s\",\n",
                         	"                                                                   analyzerClass.getSimpleName(),\n",
                         	"                                                                   cd.type.asCQL3Type()));\n",
                         	"            }\n",
                         	"            catch (InstantiationException | IllegalAccessException e)\n",
                         	"            {\n",
                         	"                throw new ConfigurationException(String.format(\"Unable to initialize analyzer class option specified [%s]\",\n",
                         	"                                                               analyzerClass.getSimpleName()));\n",
                         	"            }\n"};
    
                         	
                         	          
#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/SASIIndex.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/SASIIndex.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 145)
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
    system("cp ./fixed/SASIIndex.java ../src/java/org/apache/cassandra/index/sasi/");
    printf("create new SASIIndex.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/SASIIndex.java ../src/java/org/apache/cassandra/index/sasi/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    fp1 = fopen("./origin/AbstractAnalyzer.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/AbstractAnalyzer.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
    	if (i == 50)
        {
            fputs(str2, fp2);
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
    system("cp ./fixed/AbstractAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("create new AbstractAnalyzer.java and cp ...\n");
#else
    system("cp ./origin/AbstractAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("use origin file ...\n");
#endif

#ifdef codeC
    fp1 = fopen("./origin/DelimiterAnalyzer.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/DelimiterAnalyzer.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
    	if (i == 108)
        {
            for (int j = 0; j < 5; j++)
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
    system("cp ./fixed/DelimiterAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("create new DelimiterAnalyzer.java and cp ...\n");
#else
    system("cp ./origin/DelimiterAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("use origin file ...\n");
#endif

#ifdef codeD
    fp1 = fopen("./origin/NoOpAnalyzer.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/NoOpAnalyzer.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
    	if (i == 54)
        {
            for (int j = 0; j < 5; j++)
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
    system("cp ./fixed/NoOpAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("create new NoOpAnalyzer.java and cp ...\n");
#else
    system("cp ./origin/NoOpAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("use origin file ...\n");
#endif

#ifdef codeE
    fp1 = fopen("./origin/NonTokenizingAnalyzer.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/NonTokenizingAnalyzer.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
    	if (i == 126)
        {
            for (int j = 0; j < 5; j++)
            {
                fputs(str5[j], fp2);
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
    system("cp ./fixed/NonTokenizingAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("create new NonTokenizingAnalyzer.java and cp ...\n");
#else
    system("cp ./origin/NonTokenizingAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("use origin file ...\n");
#endif

#ifdef codeF
    fp1 = fopen("./origin/StandardAnalyzer.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/StandardAnalyzer.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
    	if (i == 25)
    	{
            fputs(str6, fp2);
            fputs(str, fp2);
    	}
    	else if (i == 26)
    	{
            fputs(str7, fp2);
            fputs(str, fp2);
    	}
    	else if (i == 29)
    	{
            fputs(str8, fp2);
            fputs(str, fp2);
    	}
	else if (i == 41)
	{
	    for (int j = 0; j < 7; j++)
	    {
		fputs(str9[j], fp2);
	    }
	    fputs(str, fp2);
	}
	else if (i == 204)
	{
	    for (int j = 0; j < 5; j++)
	    {
		fputs(str10[j], fp2);
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
    system("cp ./fixed/StandardAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("create new StandardAnalyzer.java and cp ...\n");
#else
    system("cp ./origin/StandardAnalyzer.java ../src/java/org/apache/cassandra/index/sasi/analyzer/");
    printf("use origin file ...\n");
#endif

#ifdef codeB
    fp1 = fopen("./origin/IndexMode.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    fp2 = fopen("./fixed/IndexMode.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }

    while (fgets(str, 500, fp1) != NULL)
    {
    	if (i == 95)
    	{
            fputs(str11, fp2);
    	}
        else if (i == 100)
        {
            fputs(str12, fp2);
            fputs(str, fp2);
        }
        else if (i == 102)
        {
            fputs(str13, fp2);
        }
        else if (i == 109)
        {
            for (int j = 0; j < 14; j++)
	    {
		fputs(str14[j], fp2);
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
    system("cp ./fixed/IndexMode.java ../src/java/org/apache/cassandra/index/sasi/conf/");
    printf("create new IndexMode.java and cp ...\n");
#else
    system("cp ./origin/IndexMode.java ../src/java/org/apache/cassandra/index/sasi/conf/");
    printf("use origin file ...\n");
#endif
}
