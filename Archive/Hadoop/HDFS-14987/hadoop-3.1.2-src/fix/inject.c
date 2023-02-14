#include <stdio.h>
#include <stdlib.h>
// 定义ifdef的宏，后面可以改一改，比如改成#if
//#define codeA 1
int main()
{
    FILE *fp1;
    FILE *fp2;
    int i = 0;
    char str[500]; // 读取文件的缓存区
    // 下面是修复代码
    char str1[14][200]    = {	"      // report block replicas status on datanodes\n",
    				"      if (blockInfo.isStriped()) {\n",
    				"        for (int idx = (blockInfo.getCapacity() - 1); idx >= 0; idx--) {\n",
    				"          DatanodeDescriptor dn = blockInfo.getDatanode(idx);\n",
    				"          if (dn == null) {\n",
    				"            continue;\n",
    				"          }\n",
    				"          printDatanodeReplicaStatus(block, corruptionRecord, dn);\n",
    				"        }\n",
    				"      } else {\n",
    				"        for (int idx = (blockInfo.numNodes() - 1); idx >= 0; idx--) {\n",
    				"          DatanodeDescriptor dn = blockInfo.getDatanode(idx);\n",
    				"          printDatanodeReplicaStatus(block, corruptionRecord, dn);\n",
    				"        }\n"};
    				
    char str2[21][200]    = {	"  private void printDatanodeReplicaStatus(Block block,\n",
    				"      Collection<DatanodeDescriptor> corruptionRecord, DatanodeDescriptor dn) {\n",
    				"    out.print(\"Block replica on datanode/rack: \" + dn.getHostName() +\n",
    				"        dn.getNetworkLocation() + \" \");\n",
    				"    if (corruptionRecord != null && corruptionRecord.contains(dn)) {\n",
    				"      out.print(CORRUPT_STATUS + \"\\t ReasonCode: \" +\n",
    				"          blockManager.getCorruptReason(block, dn));\n",
    				"    } else if (dn.isDecommissioned()){\n",
    				"      out.print(DECOMMISSIONED_STATUS);\n",
    				"    } else if (dn.isDecommissionInProgress()) {\n",
    				"      out.print(DECOMMISSIONING_STATUS);\n",
    				"    } else if (this.showMaintenanceState && dn.isEnteringMaintenance()) {\n",
    				"      out.print(ENTERING_MAINTENANCE_STATUS);\n",
    				"    } else if (this.showMaintenanceState && dn.isInMaintenance()) {\n",
    				"      out.print(IN_MAINTENANCE_STATUS);\n",
    				"    } else {\n",
    				"      out.print(HEALTHY_STATUS);\n",
    				"    }\n",
    				"    out.print(\"\\n\");\n",
    				"  }\n",
    				"\n"};


#ifdef codeA
    // 第一个错误
    // 打开文件，在文件夹下新建origin文件夹，并把待修改文件放进去
    fp1 = fopen("./origin/NamenodeFsck.java", "r");
    if (fp1 == NULL)
    {
        perror("打开文件w时发生错误");
        return -1;
    }
    // 这里是中间文件
    fp2 = fopen("./fixed/NamenodeFsck.java", "w+");
    if (fp2 == NULL)
    {
        perror("打开文件w2时发生错误");
        return -1;
    }
    // while搜索语句
    while (fgets(str, 500, fp1) != NULL)
    {
        if (i == 305)
        {
            for (int j = 0; j < 14; j++)
            {
                fputs(str1[j], fp2);
            }
        }
        else if (i == 337)
        {
            for (int j = 0; j < 21; j++)
            {
                fputs(str2[j], fp2);
            }
            fputs(str, fp2);
        }
        else if (i == 306 || i == 307 || i == 308 || i == 309 || i == 310 || i == 311 || i == 312 || i == 313 || i == 314 || i == 315 || i == 316 || i == 317 || i == 318 || i == 319 || i == 320 || i == 321 || i == 322 || i == 323 || i == 324)
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
    system("cp ./fixed/NamenodeFsck.java ../hadoop-hdfs-project/hadoop-hdfs/src/main/java/org/apache/hadoop/hdfs/server/namenode/");
    printf("create new NamenodeFsck.java and cp ...\n");
#else
    // 不修改就把原本的文件放进去
    system("cp ./origin/NamenodeFsck.java ../hadoop-hdfs-project/hadoop-hdfs/src/main/java/org/apache/hadoop/hdfs/server/namenode/");
    printf("use origin file ...\n");
#endif
}
