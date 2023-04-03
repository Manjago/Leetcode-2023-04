.version 61 0
.class public super MainLambda
.super java/lang/Object

.method public <init> : ()V
    .code stack 1 locals 1
L0:     aload_0
L1:     invokespecial Method java/lang/Object <init> ()V
L4:     return
L5:     
        .linenumbertable
            L0 3
        .end linenumbertable
        .localvariabletable
            0 is this LMainLambda; from L0 to L5
        .end localvariabletable
    .end code
.end method

.method public static main : ([Ljava/lang/String;)V
    .code stack 1 locals 1
L0:     invokedynamic [_7]
L5:     invokestatic Method MainLambda testPrint (Ljava/util/function/Supplier;)V
L8:     return
L9:     
        .linenumbertable
            L0 5
            L8 6
        .end linenumbertable
        .localvariabletable
            0 is args [Ljava/lang/String; from L0 to L9
        .end localvariabletable
    .end code
.end method

.method public static testPrint : (Ljava/util/function/Supplier;)V
    .code stack 2 locals 1
L0:     getstatic Field java/lang/System out Ljava/io/PrintStream;
L3:     aload_0
L4:     invokeinterface InterfaceMethod java/util/function/Supplier get ()Ljava/lang/Object; 1
L9:     checkcast java/lang/String
L12:    invokevirtual Method java/io/PrintStream println (Ljava/lang/String;)V
L15:    return
L16:    
        .linenumbertable
            L0 9
            L15 10
        .end linenumbertable
        .localvariabletable
            0 is s Ljava/util/function/Supplier; from L0 to L16
        .end localvariabletable
        .localvariabletypetable
            0 is s Ljava/util/function/Supplier<Ljava/lang/String;>; from L0 to L16
        .end localvariabletypetable
    .end code
    .signature (Ljava/util/function/Supplier<Ljava/lang/String;>;)V
.end method

.method private static synthetic lambda$main$0 : ()Ljava/lang/String;
    .code stack 1 locals 0
L0:     ldc "Hello, world!"
L2:     areturn
L3:     
        .linenumbertable
            L0 5
        .end linenumbertable
    .end code
.end method
.sourcefile "MainLambda.java"
.bootstrapmethods
.innerclasses
    java/lang/invoke/MethodHandles$Lookup java/lang/invoke/MethodHandles Lookup public static final
.end innerclasses
.const [_7] = InvokeDynamic invokeStatic Method java/lang/invoke/LambdaMetafactory metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; MethodType ()Ljava/lang/Object; [_66] MethodType ()Ljava/lang/String; : get ()Ljava/util/function/Supplier;
.const [_66] = MethodHandle invokeStatic Method MainLambda lambda$main$0 ()Ljava/lang/String;
.end class
