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
static const char *ng0 = "C:/Users/jgoh070/Desktop/Lab3_5stage pipeline with LDUR and STUR/alu.v";
static unsigned int ng1[] = {0U, 0U};
static unsigned int ng2[] = {1U, 0U};
static unsigned int ng3[] = {2U, 0U};
static unsigned int ng4[] = {3U, 0U};
static unsigned int ng5[] = {4U, 0U};
static unsigned int ng6[] = {5U, 0U};
static int ng7[] = {0, 0, 0, 0};



static void Always_18_0(char *t0)
{
    char t10[16];
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    int t6;
    char *t7;
    char *t8;
    char *t9;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    char *t19;
    unsigned int t20;
    char *t21;
    unsigned int t22;
    char *t23;
    unsigned int t24;
    unsigned int t25;
    unsigned int t26;
    unsigned int t27;
    unsigned int t28;
    unsigned int t29;
    unsigned int t30;
    unsigned int t31;
    char *t32;
    unsigned int t33;
    char *t34;
    char *t35;
    unsigned int t36;
    char *t37;
    unsigned int t38;
    unsigned int t39;
    unsigned int t40;
    unsigned int t41;
    unsigned int t42;
    unsigned int t43;
    unsigned int t44;
    unsigned int t45;
    int t46;
    int t47;
    unsigned int t48;
    unsigned int t49;
    unsigned int t50;
    unsigned int t51;
    unsigned int t52;
    unsigned int t53;
    char *t54;

LAB0:    t1 = (t0 + 2688U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(18, ng0);
    t2 = (t0 + 3008);
    *((int *)t2) = 1;
    t3 = (t0 + 2720);
    *((char **)t3) = t2;
    *((char **)t1) = &&LAB4;

LAB1:    return;
LAB4:    xsi_set_current_line(19, ng0);

LAB5:    xsi_set_current_line(20, ng0);
    t4 = (t0 + 1368U);
    t5 = *((char **)t4);

LAB6:    t4 = ((char*)((ng1)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t4, 3);
    if (t6 == 1)
        goto LAB7;

LAB8:    t2 = ((char*)((ng2)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 3);
    if (t6 == 1)
        goto LAB9;

LAB10:    t2 = ((char*)((ng3)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 3);
    if (t6 == 1)
        goto LAB11;

LAB12:    t2 = ((char*)((ng4)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 3);
    if (t6 == 1)
        goto LAB13;

LAB14:    t2 = ((char*)((ng5)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 3);
    if (t6 == 1)
        goto LAB15;

LAB16:    t2 = ((char*)((ng6)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 3);
    if (t6 == 1)
        goto LAB17;

LAB18:
LAB20:
LAB19:    xsi_set_current_line(29, ng0);
    t2 = ((char*)((ng7)));
    t3 = (t0 + 1768);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 64);

LAB21:    goto LAB2;

LAB7:    xsi_set_current_line(21, ng0);
    t7 = (t0 + 1048U);
    t8 = *((char **)t7);
    t7 = (t0 + 1208U);
    t9 = *((char **)t7);
    xsi_vlog_unsigned_add(t10, 64, t8, 64, t9, 64);
    t7 = (t0 + 1768);
    xsi_vlogvar_assign_value(t7, t10, 0, 0, 64);
    goto LAB21;

LAB9:    xsi_set_current_line(22, ng0);
    t3 = (t0 + 1048U);
    t4 = *((char **)t3);
    t3 = (t0 + 1208U);
    t7 = *((char **)t3);
    xsi_vlog_unsigned_minus(t10, 64, t4, 64, t7, 64);
    t3 = (t0 + 1768);
    xsi_vlogvar_assign_value(t3, t10, 0, 0, 64);
    goto LAB21;

LAB11:    xsi_set_current_line(23, ng0);
    t3 = (t0 + 1048U);
    t4 = *((char **)t3);
    t3 = (t0 + 1208U);
    t7 = *((char **)t3);
    t11 = 0;

LAB25:    t12 = (t11 < 2);
    if (t12 == 1)
        goto LAB26;

LAB27:    t54 = (t0 + 1768);
    xsi_vlogvar_assign_value(t54, t10, 0, 0, 64);
    goto LAB21;

LAB13:    xsi_set_current_line(24, ng0);
    t3 = (t0 + 1048U);
    t4 = *((char **)t3);
    t3 = (t0 + 1208U);
    t7 = *((char **)t3);
    t11 = 0;

LAB31:    t12 = (t11 < 2);
    if (t12 == 1)
        goto LAB32;

LAB33:    t32 = (t0 + 1768);
    xsi_vlogvar_assign_value(t32, t10, 0, 0, 64);
    goto LAB21;

LAB15:    xsi_set_current_line(25, ng0);
    t3 = (t0 + 1048U);
    t4 = *((char **)t3);
    t3 = (t0 + 1208U);
    t7 = *((char **)t3);
    t11 = 0;

LAB37:    t12 = (t11 < 2);
    if (t12 == 1)
        goto LAB38;

LAB39:    t54 = (t0 + 1768);
    xsi_vlogvar_assign_value(t54, t10, 0, 0, 64);
    goto LAB21;

LAB17:    xsi_set_current_line(26, ng0);
    t3 = (t0 + 1208U);
    t4 = *((char **)t3);
    t3 = (t0 + 1768);
    xsi_vlogvar_assign_value(t3, t4, 0, 0, 64);
    goto LAB21;

LAB22:    t29 = (t11 * 8);
    t30 = *((unsigned int *)t9);
    t31 = *((unsigned int *)t23);
    *((unsigned int *)t9) = (t30 | t31);
    t32 = (t4 + t29);
    t33 = (t29 + 4);
    t34 = (t4 + t33);
    t35 = (t7 + t29);
    t36 = (t29 + 4);
    t37 = (t7 + t36);
    t38 = *((unsigned int *)t32);
    t39 = (~(t38));
    t40 = *((unsigned int *)t34);
    t41 = (~(t40));
    t42 = *((unsigned int *)t35);
    t43 = (~(t42));
    t44 = *((unsigned int *)t37);
    t45 = (~(t44));
    t46 = (t39 & t41);
    t47 = (t43 & t45);
    t48 = (~(t46));
    t49 = (~(t47));
    t50 = *((unsigned int *)t23);
    *((unsigned int *)t23) = (t50 & t48);
    t51 = *((unsigned int *)t23);
    *((unsigned int *)t23) = (t51 & t49);
    t52 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t52 & t48);
    t53 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t53 & t49);

LAB24:    t11 = (t11 + 1);
    goto LAB25;

LAB23:    goto LAB24;

LAB26:    t13 = (t11 * 8);
    t3 = (t4 + t13);
    t8 = (t7 + t13);
    t9 = (t10 + t13);
    t14 = *((unsigned int *)t3);
    t15 = *((unsigned int *)t8);
    t16 = (t14 & t15);
    *((unsigned int *)t9) = t16;
    t17 = (t11 * 8);
    t18 = (t17 + 4);
    t19 = (t4 + t18);
    t20 = (t17 + 4);
    t21 = (t7 + t20);
    t22 = (t17 + 4);
    t23 = (t10 + t22);
    t24 = *((unsigned int *)t19);
    t25 = *((unsigned int *)t21);
    t26 = (t24 | t25);
    *((unsigned int *)t23) = t26;
    t27 = *((unsigned int *)t23);
    t28 = (t27 != 0);
    if (t28 == 1)
        goto LAB22;
    else
        goto LAB23;

LAB28:    t29 = *((unsigned int *)t9);
    t30 = *((unsigned int *)t23);
    *((unsigned int *)t9) = (t29 | t30);

LAB30:    t11 = (t11 + 1);
    goto LAB31;

LAB29:    goto LAB30;

LAB32:    t13 = (t11 * 8);
    t3 = (t4 + t13);
    t8 = (t7 + t13);
    t9 = (t10 + t13);
    t14 = *((unsigned int *)t3);
    t15 = *((unsigned int *)t8);
    t16 = (t14 ^ t15);
    *((unsigned int *)t9) = t16;
    t17 = (t11 * 8);
    t18 = (t17 + 4);
    t19 = (t4 + t18);
    t20 = (t17 + 4);
    t21 = (t7 + t20);
    t22 = (t17 + 4);
    t23 = (t10 + t22);
    t24 = *((unsigned int *)t19);
    t25 = *((unsigned int *)t21);
    t26 = (t24 | t25);
    *((unsigned int *)t23) = t26;
    t27 = *((unsigned int *)t23);
    t28 = (t27 != 0);
    if (t28 == 1)
        goto LAB28;
    else
        goto LAB29;

LAB34:    t29 = (t11 * 8);
    t30 = *((unsigned int *)t9);
    t31 = *((unsigned int *)t23);
    *((unsigned int *)t9) = (t30 | t31);
    t32 = (t4 + t29);
    t33 = (t29 + 4);
    t34 = (t4 + t33);
    t35 = (t7 + t29);
    t36 = (t29 + 4);
    t37 = (t7 + t36);
    t38 = *((unsigned int *)t34);
    t39 = (~(t38));
    t40 = *((unsigned int *)t32);
    t46 = (t40 & t39);
    t41 = *((unsigned int *)t37);
    t42 = (~(t41));
    t43 = *((unsigned int *)t35);
    t47 = (t43 & t42);
    t44 = (~(t46));
    t45 = (~(t47));
    t48 = *((unsigned int *)t23);
    *((unsigned int *)t23) = (t48 & t44);
    t49 = *((unsigned int *)t23);
    *((unsigned int *)t23) = (t49 & t45);

LAB36:    t11 = (t11 + 1);
    goto LAB37;

LAB35:    goto LAB36;

LAB38:    t13 = (t11 * 8);
    t3 = (t4 + t13);
    t8 = (t7 + t13);
    t9 = (t10 + t13);
    t14 = *((unsigned int *)t3);
    t15 = *((unsigned int *)t8);
    t16 = (t14 | t15);
    *((unsigned int *)t9) = t16;
    t17 = (t11 * 8);
    t18 = (t17 + 4);
    t19 = (t4 + t18);
    t20 = (t17 + 4);
    t21 = (t7 + t20);
    t22 = (t17 + 4);
    t23 = (t10 + t22);
    t24 = *((unsigned int *)t19);
    t25 = *((unsigned int *)t21);
    t26 = (t24 | t25);
    *((unsigned int *)t23) = t26;
    t27 = *((unsigned int *)t23);
    t28 = (t27 != 0);
    if (t28 == 1)
        goto LAB34;
    else
        goto LAB35;

}


extern void work_m_00000000000667100592_2725559894_init()
{
	static char *pe[] = {(void *)Always_18_0};
	xsi_register_didat("work_m_00000000000667100592_2725559894", "isim/test_bench_5_stage_pipeline_isim_beh.exe.sim/work/m_00000000000667100592_2725559894.didat");
	xsi_register_executes(pe);
}
