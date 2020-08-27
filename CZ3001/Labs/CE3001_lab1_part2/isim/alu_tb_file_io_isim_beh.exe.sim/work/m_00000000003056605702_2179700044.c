/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

/* This file is designed for use with ISim build 0x7708f090 */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "C:/Users/jgoh070/Desktop/CE3001_lab1_part2/alutest.v";
static int ng1[] = {0, 0};
static unsigned int ng2[] = {0U, 0U};
static const char *ng3 = "input.txt";
static const char *ng4 = "r";
static const char *ng5 = "output.txt";
static const char *ng6 = "w";
static int ng7[] = {47, 0};
static int ng8[] = {35, 0};
static int ng9[] = {37, 0};
static const char *ng10 = "%h %h %h \n";
static const char *ng11 = "%h\n";



static void Initial_22_0(char *t0)
{
    char t4[8];
    char t6[8];
    char t24[8];
    char t74[8];
    char t90[8];
    char t130[8];
    char *t1;
    char *t2;
    char *t3;
    char *t5;
    char *t7;
    char *t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    char *t14;
    char *t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    unsigned int t19;
    unsigned int t20;
    char *t21;
    char *t22;
    char *t23;
    char *t25;
    char *t26;
    unsigned int t27;
    unsigned int t28;
    char *t29;
    unsigned int t30;
    unsigned int t31;
    unsigned int t32;
    unsigned int t33;
    unsigned int t34;
    unsigned int t35;
    unsigned int t36;
    unsigned int t37;
    unsigned int t38;
    unsigned int t39;
    unsigned int t40;
    unsigned int t41;
    char *t42;
    unsigned int t43;
    unsigned int t44;
    unsigned int t45;
    char *t46;
    char *t47;
    char *t48;
    unsigned int t49;
    unsigned int t50;
    unsigned int t51;
    unsigned int t52;
    unsigned int t53;
    unsigned int t54;
    unsigned int t55;
    char *t56;
    char *t57;
    unsigned int t58;
    unsigned int t59;
    unsigned int t60;
    int t61;
    unsigned int t62;
    unsigned int t63;
    unsigned int t64;
    int t65;
    unsigned int t66;
    unsigned int t67;
    unsigned int t68;
    unsigned int t69;
    char *t70;
    char *t71;
    char *t72;
    char *t73;
    char *t75;
    char *t76;
    unsigned int t77;
    unsigned int t78;
    unsigned int t79;
    unsigned int t80;
    unsigned int t81;
    unsigned int t82;
    unsigned int t83;
    unsigned int t84;
    unsigned int t85;
    unsigned int t86;
    unsigned int t87;
    unsigned int t88;
    char *t89;
    unsigned int t91;
    unsigned int t92;
    unsigned int t93;
    char *t94;
    char *t95;
    char *t96;
    unsigned int t97;
    unsigned int t98;
    unsigned int t99;
    unsigned int t100;
    unsigned int t101;
    unsigned int t102;
    unsigned int t103;
    char *t104;
    char *t105;
    unsigned int t106;
    unsigned int t107;
    unsigned int t108;
    int t109;
    unsigned int t110;
    unsigned int t111;
    unsigned int t112;
    int t113;
    unsigned int t114;
    unsigned int t115;
    unsigned int t116;
    unsigned int t117;
    char *t118;
    unsigned int t119;
    unsigned int t120;
    unsigned int t121;
    unsigned int t122;
    unsigned int t123;
    char *t124;
    char *t125;
    char *t126;
    char *t127;
    char *t128;
    char *t129;
    char *t131;
    char *t132;

LAB0:    t1 = (t0 + 3784U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(23, ng0);

LAB4:    xsi_set_current_line(24, ng0);
    t2 = ((char*)((ng1)));
    t3 = (t0 + 1584);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 4);
    xsi_set_current_line(24, ng0);
    t2 = ((char*)((ng1)));
    t3 = (t0 + 1744);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 4);
    xsi_set_current_line(24, ng0);
    t2 = ((char*)((ng2)));
    t3 = (t0 + 1904);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 3);
    xsi_set_current_line(25, ng0);
    *((int *)t4) = xsi_vlogfile_file_open_of_cname_ctype(ng3, ng4);
    t2 = (t4 + 4);
    *((int *)t2) = 0;
    t3 = (t0 + 2064);
    xsi_vlogvar_assign_value(t3, t4, 0, 0, 32);
    xsi_set_current_line(26, ng0);
    *((int *)t4) = xsi_vlogfile_file_open_of_cname_ctype(ng5, ng6);
    t2 = (t4 + 4);
    *((int *)t2) = 0;
    t3 = (t0 + 2224);
    xsi_vlogvar_assign_value(t3, t4, 0, 0, 32);
    xsi_set_current_line(30, ng0);

LAB5:    t2 = (t0 + 2064);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    *((int *)t6) = xsi_vlogfile_feof(*((unsigned int *)t5));
    t7 = (t6 + 4);
    *((int *)t7) = 0;
    memset(t4, 0, 8);
    t8 = (t6 + 4);
    t9 = *((unsigned int *)t8);
    t10 = (~(t9));
    t11 = *((unsigned int *)t6);
    t12 = (t11 & t10);
    t13 = (t12 & 4294967295U);
    if (t13 != 0)
        goto LAB9;

LAB7:    if (*((unsigned int *)t8) == 0)
        goto LAB6;

LAB8:    t14 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t14) = 1;

LAB9:    t15 = (t4 + 4);
    t16 = *((unsigned int *)t15);
    t17 = (~(t16));
    t18 = *((unsigned int *)t4);
    t19 = (t18 & t17);
    t20 = (t19 != 0);
    if (t20 > 0)
        goto LAB10;

LAB11:    xsi_set_current_line(45, ng0);
    t2 = (t0 + 3592);
    xsi_process_wait(t2, 10000LL);
    *((char **)t1) = &&LAB37;

LAB1:    return;
LAB6:    *((unsigned int *)t4) = 1;
    goto LAB9;

LAB10:    xsi_set_current_line(31, ng0);

LAB12:    xsi_set_current_line(32, ng0);
    t21 = (t0 + 2064);
    t22 = (t21 + 56U);
    t23 = *((char **)t22);
    *((int *)t24) = xsi_vlogfile_fgetc(*((unsigned int *)t23));
    t25 = (t24 + 4);
    *((int *)t25) = 0;
    t26 = (t0 + 2384);
    xsi_vlogvar_assign_value(t26, t24, 0, 0, 32);
    xsi_set_current_line(34, ng0);
    t2 = (t0 + 2384);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    t7 = ((char*)((ng7)));
    memset(t4, 0, 8);
    t8 = (t5 + 4);
    t14 = (t7 + 4);
    t9 = *((unsigned int *)t5);
    t10 = *((unsigned int *)t7);
    t11 = (t9 ^ t10);
    t12 = *((unsigned int *)t8);
    t13 = *((unsigned int *)t14);
    t16 = (t12 ^ t13);
    t17 = (t11 | t16);
    t18 = *((unsigned int *)t8);
    t19 = *((unsigned int *)t14);
    t20 = (t18 | t19);
    t27 = (~(t20));
    t28 = (t17 & t27);
    if (t28 != 0)
        goto LAB16;

LAB13:    if (t20 != 0)
        goto LAB15;

LAB14:    *((unsigned int *)t4) = 1;

LAB16:    t21 = (t0 + 2384);
    t22 = (t21 + 56U);
    t23 = *((char **)t22);
    t25 = ((char*)((ng8)));
    memset(t6, 0, 8);
    t26 = (t23 + 4);
    t29 = (t25 + 4);
    t30 = *((unsigned int *)t23);
    t31 = *((unsigned int *)t25);
    t32 = (t30 ^ t31);
    t33 = *((unsigned int *)t26);
    t34 = *((unsigned int *)t29);
    t35 = (t33 ^ t34);
    t36 = (t32 | t35);
    t37 = *((unsigned int *)t26);
    t38 = *((unsigned int *)t29);
    t39 = (t37 | t38);
    t40 = (~(t39));
    t41 = (t36 & t40);
    if (t41 != 0)
        goto LAB20;

LAB17:    if (t39 != 0)
        goto LAB19;

LAB18:    *((unsigned int *)t6) = 1;

LAB20:    t43 = *((unsigned int *)t4);
    t44 = *((unsigned int *)t6);
    t45 = (t43 | t44);
    *((unsigned int *)t24) = t45;
    t46 = (t4 + 4);
    t47 = (t6 + 4);
    t48 = (t24 + 4);
    t49 = *((unsigned int *)t46);
    t50 = *((unsigned int *)t47);
    t51 = (t49 | t50);
    *((unsigned int *)t48) = t51;
    t52 = *((unsigned int *)t48);
    t53 = (t52 != 0);
    if (t53 == 1)
        goto LAB21;

LAB22:
LAB23:    t70 = (t0 + 2384);
    t71 = (t70 + 56U);
    t72 = *((char **)t71);
    t73 = ((char*)((ng9)));
    memset(t74, 0, 8);
    t75 = (t72 + 4);
    t76 = (t73 + 4);
    t77 = *((unsigned int *)t72);
    t78 = *((unsigned int *)t73);
    t79 = (t77 ^ t78);
    t80 = *((unsigned int *)t75);
    t81 = *((unsigned int *)t76);
    t82 = (t80 ^ t81);
    t83 = (t79 | t82);
    t84 = *((unsigned int *)t75);
    t85 = *((unsigned int *)t76);
    t86 = (t84 | t85);
    t87 = (~(t86));
    t88 = (t83 & t87);
    if (t88 != 0)
        goto LAB27;

LAB24:    if (t86 != 0)
        goto LAB26;

LAB25:    *((unsigned int *)t74) = 1;

LAB27:    t91 = *((unsigned int *)t24);
    t92 = *((unsigned int *)t74);
    t93 = (t91 | t92);
    *((unsigned int *)t90) = t93;
    t94 = (t24 + 4);
    t95 = (t74 + 4);
    t96 = (t90 + 4);
    t97 = *((unsigned int *)t94);
    t98 = *((unsigned int *)t95);
    t99 = (t97 | t98);
    *((unsigned int *)t96) = t99;
    t100 = *((unsigned int *)t96);
    t101 = (t100 != 0);
    if (t101 == 1)
        goto LAB28;

LAB29:
LAB30:    t118 = (t90 + 4);
    t119 = *((unsigned int *)t118);
    t120 = (~(t119));
    t121 = *((unsigned int *)t90);
    t122 = (t121 & t120);
    t123 = (t122 != 0);
    if (t123 > 0)
        goto LAB31;

LAB32:    xsi_set_current_line(37, ng0);

LAB34:    xsi_set_current_line(39, ng0);
    t2 = (t0 + 2384);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    t7 = (t0 + 2064);
    t8 = (t7 + 56U);
    t14 = *((char **)t8);
    *((int *)t4) = xsi_vlogfile_ungetc(*((unsigned int *)t5), *((unsigned int *)t14));
    t15 = (t4 + 4);
    *((int *)t15) = 0;
    t21 = (t0 + 2544);
    xsi_vlogvar_assign_value(t21, t4, 0, 0, 32);
    xsi_set_current_line(40, ng0);
    t2 = (t0 + 3592);
    xsi_process_wait(t2, 10000LL);
    *((char **)t1) = &&LAB35;
    goto LAB1;

LAB15:    t15 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t15) = 1;
    goto LAB16;

LAB19:    t42 = (t6 + 4);
    *((unsigned int *)t6) = 1;
    *((unsigned int *)t42) = 1;
    goto LAB20;

LAB21:    t54 = *((unsigned int *)t24);
    t55 = *((unsigned int *)t48);
    *((unsigned int *)t24) = (t54 | t55);
    t56 = (t4 + 4);
    t57 = (t6 + 4);
    t58 = *((unsigned int *)t56);
    t59 = (~(t58));
    t60 = *((unsigned int *)t4);
    t61 = (t60 & t59);
    t62 = *((unsigned int *)t57);
    t63 = (~(t62));
    t64 = *((unsigned int *)t6);
    t65 = (t64 & t63);
    t66 = (~(t61));
    t67 = (~(t65));
    t68 = *((unsigned int *)t48);
    *((unsigned int *)t48) = (t68 & t66);
    t69 = *((unsigned int *)t48);
    *((unsigned int *)t48) = (t69 & t67);
    goto LAB23;

LAB26:    t89 = (t74 + 4);
    *((unsigned int *)t74) = 1;
    *((unsigned int *)t89) = 1;
    goto LAB27;

LAB28:    t102 = *((unsigned int *)t90);
    t103 = *((unsigned int *)t96);
    *((unsigned int *)t90) = (t102 | t103);
    t104 = (t24 + 4);
    t105 = (t74 + 4);
    t106 = *((unsigned int *)t104);
    t107 = (~(t106));
    t108 = *((unsigned int *)t24);
    t109 = (t108 & t107);
    t110 = *((unsigned int *)t105);
    t111 = (~(t110));
    t112 = *((unsigned int *)t74);
    t113 = (t112 & t111);
    t114 = (~(t109));
    t115 = (~(t113));
    t116 = *((unsigned int *)t96);
    *((unsigned int *)t96) = (t116 & t114);
    t117 = *((unsigned int *)t96);
    *((unsigned int *)t96) = (t117 & t115);
    goto LAB30;

LAB31:    xsi_set_current_line(35, ng0);
    t124 = (t0 + 2864);
    t125 = (t124 + 56U);
    t126 = *((char **)t125);
    t127 = (t0 + 2064);
    t128 = (t127 + 56U);
    t129 = *((char **)t128);
    *((int *)t130) = xsi_vlogfile_fgets(t126, 8001, *((unsigned int *)t129));
    t131 = (t130 + 4);
    *((int *)t131) = 0;
    t132 = (t0 + 2544);
    xsi_vlogvar_assign_value(t132, t130, 0, 0, 32);

LAB33:    goto LAB5;

LAB35:    xsi_set_current_line(40, ng0);
    t3 = (t0 + 2064);
    t5 = (t3 + 56U);
    t7 = *((char **)t5);
    t8 = (t0 + 1584);
    t14 = (t8 + 56U);
    t15 = *((char **)t14);
    xsi_vlog_bit_copy(t4, 0, t15, 0, 4);
    t21 = (t0 + 1744);
    t22 = (t21 + 56U);
    t23 = *((char **)t22);
    xsi_vlog_bit_copy(t6, 0, t23, 0, 4);
    t25 = (t0 + 1904);
    t26 = (t25 + 56U);
    t29 = *((char **)t26);
    xsi_vlog_bit_copy(t24, 0, t29, 0, 3);
    *((int *)t74) = xsi_vlogfile_fscanf(*((unsigned int *)t7), ng10, 4, t0, (char)118, t4, 4, (char)118, t6, 4, (char)118, t24, 3);
    t42 = (t74 + 4);
    *((int *)t42) = 0;
    t46 = (t0 + 1584);
    xsi_vlogvar_assign_value(t46, t4, 0, 0, 4);
    t47 = (t0 + 1744);
    xsi_vlogvar_assign_value(t47, t6, 0, 0, 4);
    t48 = (t0 + 1904);
    xsi_vlogvar_assign_value(t48, t24, 0, 0, 3);
    t56 = (t0 + 2544);
    xsi_vlogvar_assign_value(t56, t74, 0, 0, 32);
    xsi_set_current_line(42, ng0);
    t2 = (t0 + 3592);
    xsi_process_wait(t2, 10000LL);
    *((char **)t1) = &&LAB36;
    goto LAB1;

LAB36:    xsi_set_current_line(42, ng0);
    t3 = (t0 + 2224);
    t5 = (t3 + 56U);
    t7 = *((char **)t5);
    t8 = (t0 + 1184U);
    t14 = *((char **)t8);
    xsi_vlogfile_fwrite(*((unsigned int *)t7), 0, 0, 1, ng11, 2, t0, (char)118, t14, 4);
    goto LAB33;

LAB37:    xsi_set_current_line(46, ng0);
    t2 = (t0 + 2064);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    xsi_vlogfile_fclose(*((unsigned int *)t5));
    xsi_set_current_line(47, ng0);
    t2 = (t0 + 2224);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    xsi_vlogfile_fclose(*((unsigned int *)t5));
    xsi_set_current_line(48, ng0);
    xsi_vlog_finish(1);
    goto LAB1;

}


extern void work_m_00000000003056605702_2179700044_init()
{
	static char *pe[] = {(void *)Initial_22_0};
	xsi_register_didat("work_m_00000000003056605702_2179700044", "isim/alu_tb_file_io_isim_beh.exe.sim/work/m_00000000003056605702_2179700044.didat");
	xsi_register_executes(pe);
}
