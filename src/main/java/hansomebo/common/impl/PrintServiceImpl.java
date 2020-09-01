package hansomebo.common.impl;


import hansomebo.common.service.PrintService;

public class PrintServiceImpl implements PrintService {

    @Override
    public void PrintString(String s) {
        System.out.println("PrintServiceImpl : " + s);
    }

}
