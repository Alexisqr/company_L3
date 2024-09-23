package edu.pzks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
/*
@author   Oleksandra Hrytsiuk
@project   company
@class  CompanyServiceImplTest
@version  1.0.0
@since 22.09.2024 - 18.06
*/


class CompanyServiceImplTest {
    private final Company main = new Company(null, 3);
    private final Company bookkeeping = new Company(main, 2);
    private final Company development = new Company(main, 4);
    private final Company design = new Company(development, 3);
    private final Company frontend = new Company(development, 10);
    private final Company backend = new Company(development, 11);
    private final Company bd = new Company(backend, 3);
    private final Company bubusinessLogic = new Company(backend, 5);
    private final Company hr = new Company(main, 2);           // Відділ кадрів
    private final Company sales = new Company(main, 4);        // Відділ продажів
    private final Company marketing = new Company(main, 4);    // Відділ маркетингу
    private final Company qa = new Company(development, 2);
    // ....
    List<Company> companies = List.of(main, bookkeeping,development,design,frontend,backend,bd,bubusinessLogic,hr,sales,marketing,qa);

    private final ICompanyService underTest = new CompanyServiceImpl();

    @BeforeEach
    void setUp() {
    }
    @Test
    void whenParentIsNullThenItIsTheTop() {
        Company result = underTest.getTopLevelParent(main);
        Assertions.assertEquals(main, result);
    }
    @Test
    void whenBookkeepingThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(bookkeeping);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenDevelopmentThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(development);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenDesignThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(design);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenFrontendThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(frontend);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenBackendThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(backend);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenBDThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(bd);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenBusinessLogicThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(bubusinessLogic);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenHRThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(hr);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenQATeamThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(qa);
        Assertions.assertEquals(main, result);
    }
    //Не впевнена бо в принципі по ірархії повторюються як bookkeeping
    @Test
    void whenSalesThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(sales);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenMarketingThenReturnTopLevelParent() {
        Company result = underTest.getTopLevelParent(marketing);
        Assertions.assertEquals(main, result);
    }
    //В відео пояснювалось по ми рахуємо від від дітей до батьків
    //Але під час тестування я зрозуміла що код працює зовсім навпаки
    //Одже фактичний результат при спробі виконання whenMainCompanyThenReturnEmployeeCount до Main = 53, а не 3

    /*
    @Test
    void whenMainCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(main, companies);
        Assertions.assertEquals(3, employeeCount);
    }
    @Test
    void whenDevelopmentCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(development, companies);
        Assertions.assertEquals(7, employeeCount);
    }
    @Test
    void whenDesignCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(design, companies);
        Assertions.assertEquals(10, employeeCount);
    }
    */
    // Подивилася скрін завдання з реалізації де йдеться саме про підрахунок від батьків + всі нащадки
    // Тому роблю згідно скріна
    @Test
    void whenMainCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(main, companies);
        Assertions.assertEquals(53, employeeCount);
    }
    @Test
    void whenDevelopmentCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(development, companies);
        Assertions.assertEquals(38, employeeCount);
    }
    @Test
    void whenDesignCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(design, companies);
        Assertions.assertEquals(3, employeeCount);
    }
    @Test
    void whenBackendCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(backend, companies);
        Assertions.assertEquals(19, employeeCount);
    }
    @Test
    void whenFrontendCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(frontend, companies);
        Assertions.assertEquals(10, employeeCount);
    }
    @Test
    void whenBDCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(bd, companies);
        Assertions.assertEquals(3, employeeCount);
    }
    @Test
    void whenBusinessLogicCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(bubusinessLogic, companies);
        Assertions.assertEquals(5, employeeCount);
    }

    @Test
    void whenHRCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(hr, companies);
        Assertions.assertEquals(2, employeeCount);
    }

    @Test
    void whenSalesCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(sales, companies);
        Assertions.assertEquals(4, employeeCount);
    }

    @Test
    void whenMarketingCompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(marketing, companies);
        Assertions.assertEquals(4, employeeCount);
    }

    @Test
    void whenQACompanyThenReturnEmployeeCount() {
        long employeeCount = underTest.getEmployeeCountForCompanyAndChildren(qa, companies);
        Assertions.assertEquals(2, employeeCount);
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void getTopLevelParent() {
    }

    @Test
    void getEmployeeCountForCompanyAndChildren() {
    }
}