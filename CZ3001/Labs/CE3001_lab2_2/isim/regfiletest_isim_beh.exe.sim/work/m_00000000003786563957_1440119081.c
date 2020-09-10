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
static const char *ng0 = "L:/CE3001_lab2_2/regfiletest.v";
static int ng1[] = {0, 0};
static const char *ng2 = "input_regfile.txt";
static const char *ng3 = "r";
static const char *ng4 = "output_regfile.txt";
static const char *ng5 = "w";
static int ng6[] = {1, 0};
static int ng7[] = {47, 0};
static int ng8[] = {35, 0};
static int ng9[] = {37, 0};
static const char *ng10 = "%h %h %h %h %h";
static const char *ng11 = "%h %h\n";



static void Always_39_0(char *t0)
{
    char t3[8];
    char *t1;
    char *t2;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    char *t13;
    char *t14;
    char *t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    unsigned int t19;
    unsigned int t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    char *t24;

LAB0:    t1 = (t0 + 4288U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(39, ng0);
    t2 = (t0 + 4096);
    xsi_process_wait(t2, 5000LL);
    *((char **)t1) = &&LAB4;

LAB1:    return;
LAB4:    xsi_set_current_line(39, ng0);
    t4 = (t0 + 1608);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    memset(t3, 0, 8);
    t7 = (t6 + 4);
    t8 = *((unsigned int *)t7);
    t9 = (~(t8));
    t10 = *((unsigned int *)t6);
    t11 = (t10 & t9);
    t12 = (t11 & 1U);
    if (t12 != 0)
        goto LAB8;

LAB6:    if (*((unsigned int *)t7) == 0)
        goto LAB5;

LAB7:    t13 = (t3 + 4);
    *((unsigned int *)t3) = 1;
    *((unsigned int *)t13) = 1;

LAB8:    t14 = (t3 + 4);
    t15 = (t6 + 4);
    t16 = *((unsigned int *)t6);
    t17 = (~(t16));
    *((unsigned int *)t3) = t17;
    *((unsigned int *)t14) = 0;
    if (*((unsigned int *)t15) != 0)
        goto LAB10;

LAB9:    t22 = *((unsigned int *)t3);
    *((unsigned int *)t3) = (t22 & 1U);
    t23 = *((unsigned int *)t14);
    *((unsigned int *)t14) = (t23 & 1U);
    t24 = (t0 + 1608);
    xsi_vlogvar_assign_value(t24, t3, 0, 0, 1);
    goto LAB2;

LAB5:    *((unsigned int *)t3) = 1;
    goto LAB8;

LAB10:    t18 = *((unsigned int *)t3);
    t19 = *((unsigned int *)t15);
    *((unsigned int *)t3) = (t18 | t19);
    t20 = *((unsigned int *)t14);
    t21 = *((unsigned int *)t15);
    *((unsigned int *)t14) = (t20 | t21);
    goto LAB9;

}

static void Initial_41_1(char *t0)
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

LAB0:    t1 = (t0 + 4536U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(42, ng0);

LAB4:    xsi_set_current_line(43, ng0);
    t2 = ((char*)((ng1)));
    t3 = (t0 + 1608);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 1);
    xsi_set_current_line(44, ng0);
    t2 = ((char*)((ng1)));
    t3 = (t0 + 1768);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 1);
    xsi_set_current_line(45, ng0);
    t2 = ((char*)((ng1)));
    t3 = (t0 + 1928);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 1);
    xsi_set_current_line(46, ng0);
    *((int *)t4) = xsi_vlogfile_file_open_of_cname_ctype(ng2, ng3);
    t2 = (t4 + 4);
    *((int *)t2) = 0;
    t3 = (t0 + 2728);
    xsi_vlogvar_assign_value(t3, t4, 0, 0, 32);
    xsi_set_current_line(47, ng0);
    *((int *)t4) = xsi_vlogfile_file_open_of_cname_ctype(ng4, ng5);
    t2 = (t4 + 4);
    *((int *)t2) = 0;
    t3 = (t0 + 2888);
    xsi_vlogvar_assign_value(t3, t4, 0, 0, 32);
    xsi_set_current_line(48, ng0);
    t2 = (t0 + 4344);
    xsi_process_wait(t2, 20000LL);
    *((char **)t1) = &&LAB5;

LAB1:    return;
LAB5:    xsi_set_current_line(48, ng0);
    t3 = ((char*)((ng6)));
    t5 = (t0 + 1768);
    xsi_vlogvar_assign_value(t5, t3, 0, 0, 1);
    xsi_set_current_line(49, ng0);
    t2 = (t0 + 4344);
    xsi_process_wait(t2, 10000LL);
    *((char **)t1) = &&LAB6;
    goto LAB1;

LAB6:    xsi_set_current_line(49, ng0);
    t3 = ((char*)((ng1)));
    t5 = (t0 + 1768);
    xsi_vlogvar_assign_value(t5, t3, 0, 0, 1);
    xsi_set_current_line(52, ng0);

LAB7:    t2 = (t0 + 2728);
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
        goto LAB11;

LAB9:    if (*((unsigned int *)t8) == 0)
        goto LAB8;

LAB10:    t14 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t14) = 1;

LAB11:    t15 = (t4 + 4);
    t16 = *((unsigned int *)t15);
    t17 = (~(t16));
    t18 = *((unsigned int *)t4);
    t19 = (t18 & t17);
    t20 = (t19 != 0);
    if (t20 > 0)
        goto LAB12;

LAB13:    xsi_set_current_line(67, ng0);
    t2 = (t0 + 2728);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    xsi_vlogfile_fclose(*((unsigned int *)t5));
    xsi_set_current_line(69, ng0);
    t2 = (t0 + 2888);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    xsi_vlogfile_fclose(*((unsigned int *)t5));
    xsi_set_current_line(70, ng0);
    t2 = (t0 + 4344);
    xsi_process_wait(t2, 100000LL);
    *((char **)t1) = &&LAB38;
    goto LAB1;

LAB8:    *((unsigned int *)t4) = 1;
    goto LAB11;

LAB12:    xsi_set_current_line(53, ng0);

LAB14:    xsi_set_current_line(54, ng0);
    t21 = (t0 + 2728);
    t22 = (t21 + 56U);
    t23 = *((char **)t22);
    *((int *)t24) = xsi_vlogfile_fgetc(*((unsigned int *)t23));
    t25 = (t24 + 4);
    *((int *)t25) = 0;
    t26 = (t0 + 3208);
    xsi_vlogvar_assign_value(t26, t24, 0, 0, 32);
    xsi_set_current_line(56, ng0);
    t2 = (t0 + 3208);
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
        goto LAB18;

LAB15:    if (t20 != 0)
        goto LAB17;

LAB16:    *((unsigned int *)t4) = 1;

LAB18:    t21 = (t0 + 3208);
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
        goto LAB22;

LAB19:    if (t39 != 0)
        goto LAB21;

LAB20:    *((unsigned int *)t6) = 1;

LAB22:    t43 = *((unsigned int *)t4);
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
        goto LAB23;

LAB24:
LAB25:    t70 = (t0 + 3208);
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
        goto LAB29;

LAB26:    if (t86 != 0)
        goto LAB28;

LAB27:    *((unsigned int *)t74) = 1;

LAB29:    t91 = *((unsigned int *)t24);
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
        goto LAB30;

LAB31:
LAB32:    t118 = (t90 + 4);
    t119 = *((unsigned int *)t118);
    t120 = (~(t119));
    t121 = *((unsigned int *)t90);
    t122 = (t121 & t120);
    t123 = (t122 != 0);
    if (t123 > 0)
        goto LAB33;

LAB34:    xsi_set_current_line(59, ng0);

LAB36:    xsi_set_current_line(61, ng0);
    t2 = (t0 + 3208);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    t7 = (t0 + 2728);
    t8 = (t7 + 56U);
    t14 = *((char **)t8);
    *((int *)t4) = xsi_vlogfile_ungetc(*((unsigned int *)t5), *((unsigned int *)t14));
    t15 = (t4 + 4);
    *((int *)t15) = 0;
    t21 = (t0 + 3048);
    xsi_vlogvar_assign_value(t21, t4, 0, 0, 32);
    xsi_set_current_line(62, ng0);
    t2 = (t0 + 2728);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    t7 = (t0 + 2088);
    t8 = (t7 + 56U);
    t14 = *((char **)t8);
    xsi_vlog_bit_copy(t4, 0, t14, 0, 2);
    t15 = (t0 + 2248);
    t21 = (t15 + 56U);
    t22 = *((char **)t21);
    xsi_vlog_bit_copy(t6, 0, t22, 0, 2);
    t23 = (t0 + 1928);
    t25 = (t23 + 56U);
    t26 = *((char **)t25);
    xsi_vlog_bit_copy(t24, 0, t26, 0, 1);
    t29 = (t0 + 2408);
    t42 = (t29 + 56U);
    t46 = *((char **)t42);
    xsi_vlog_bit_copy(t74, 0, t46, 0, 2);
    t47 = (t0 + 2568);
    t48 = (t47 + 56U);
    t56 = *((char **)t48);
    xsi_vlog_bit_copy(t90, 0, t56, 0, 4);
    *((int *)t130) = xsi_vlogfile_fscanf(*((unsigned int *)t5), ng10, 6, t0, (char)118, t4, 2, (char)118, t6, 2, (char)118, t24, 1, (char)118, t74, 2, (char)118, t90, 4);
    t57 = (t130 + 4);
    *((int *)t57) = 0;
    t70 = (t0 + 2088);
    xsi_vlogvar_assign_value(t70, t4, 0, 0, 2);
    t71 = (t0 + 2248);
    xsi_vlogvar_assign_value(t71, t6, 0, 0, 2);
    t72 = (t0 + 1928);
    xsi_vlogvar_assign_value(t72, t24, 0, 0, 1);
    t73 = (t0 + 2408);
    xsi_vlogvar_assign_value(t73, t74, 0, 0, 2);
    t75 = (t0 + 2568);
    xsi_vlogvar_assign_value(t75, t90, 0, 0, 4);
    t76 = (t0 + 3048);
    xsi_vlogvar_assign_value(t76, t130, 0, 0, 32);

LAB35:    xsi_set_current_line(64, ng0);
    t2 = (t0 + 4344);
    xsi_process_wait(t2, 10000LL);
    *((char **)t1) = &&LAB37;
    goto LAB1;

LAB17:    t15 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t15) = 1;
    goto LAB18;

LAB21:    t42 = (t6 + 4);
    *((unsigned int *)t6) = 1;
    *((unsigned int *)t42) = 1;
    goto LAB22;

LAB23:    t54 = *((unsigned int *)t24);
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
    goto LAB25;

LAB28:    t89 = (t74 + 4);
    *((unsigned int *)t74) = 1;
    *((unsigned int *)t89) = 1;
    goto LAB29;

LAB30:    t102 = *((unsigned int *)t90);
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
    goto LAB32;

LAB33:    xsi_set_current_line(57, ng0);
    t124 = (t0 + 3368);
    t125 = (t124 + 56U);
    t126 = *((char **)t125);
    t127 = (t0 + 2728);
    t128 = (t127 + 56U);
    t129 = *((char **)t128);
    *((int *)t130) = xsi_vlogfile_fgets(t126, 8001, *((unsigned int *)t129));
    t131 = (t130 + 4);
    *((int *)t131) = 0;
    t132 = (t0 + 3048);
    xsi_vlogvar_assign_value(t132, t130, 0, 0, 32);
    goto LAB35;

LAB37:    xsi_set_current_line(65, ng0);
    t2 = (t0 + 2888);
    t3 = (t2 + 56U);
    t5 = *((char **)t3);
    t7 = (t0 + 1048U);
    t8 = *((char **)t7);
    t7 = (t0 + 1208U);
    t14 = *((char **)t7);
    xsi_vlogfile_fwrite(*((unsigned int *)t5), 0, 0, 1, ng11, 3, t0, (char)118, t8, 4, (char)118, t14, 4);
    goto LAB7;

LAB38:    xsi_set_current_line(70, ng0);
    xsi_vlog_finish(1);
    goto LAB1;

}


extern void work_m_00000000003786563957_1440119081_init()
{
	static char *pe[] = {(void *)Always_39_0,(void *)Initial_41_1};
	xsi_register_didat("work_m_00000000003786563957_1440119081", "isim/regfiletest_isim_beh.exe.sim/work/m_00000000003786563957_1440119081.didat");
	xsi_register_executes(pe);
}
