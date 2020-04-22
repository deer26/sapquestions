package com.karaca.sapcertificate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.karaca.sapcertificate.QuizContract.*;

/**
 * Created by huseyin.karaca on 9.04.2018.
 */

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "KartalSap.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION6 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR1 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR2 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR5 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR6 + " TEXT, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                " ) ";
        try {
            db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        } catch (Exception e) {


        }

        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {


        Question a1 = new Question("We can use execution services to enter commitments and actual costs for planning items using easy cost planning. Which of the following postings are possible? Please choose the correct answer. ",
                "Purchase orders ",
                "Goods issues ",
                "Internal activity allocation ",
                "Direct process allocation ",
                "All the above.",
                null,
                null, null, null, null, "X", null, Question.C_TFIN22_67);
        addQuestion(a1);

        Question a2 = new Question("What do you define when you set up an operating concern for costing-based profitability analysis? There are 3 correct answers to this question. ",
                "A. Functional area",
                "B. Characteristics",
                "C. Value fields ",
                "D. Chart of accounts",
                "E. Operating concern currency",
                null,
                null, "X", "X", null, "X", null, Question.C_TFIN22_67);
        addQuestion(a2);

        Question a3 = new Question("What is the purpose of material ledger? Please choose the correct answer. ",
                "A. The requirement of track the inventories values in more than one currency in SAP ERP. ",
                "B. Multi level price determination can calculate the variances that flowed to the higher levels of production process. ",
                "C. Material ledger can be used to revaluate products or raw materials based on actual prices during the period-end closing. ",
                "D. All the above",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a3);

        Question a4 = new Question("Which results can Profit Center Accounting reports provide in New General Ledger Accounting? Note: There are 3 correct answers to this question. ",
                "A. Cost of goods sold ",
                "B. Fixed and variable cost portions ",
                "C. Balance sheet statement ",
                "D. Return on investment ",
                "E. Variance categories of production",
                null,
                "X", null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a4);

        Question a5 = new Question("Which of the following are the right organizational assignments starting from the top of the organization structure (top-down)? Please choose the correct answer. ",
                "A. Controlling area, Operating concern, Company code, Plant, Storage location ",
                "B. Company code, Operating concern, Controlling area, Plant, Storage location ",
                "C. Operating concern, Controlling area, Company code, Plant, Storage location ",
                "D. Operating concern, Controlling area, Company code, Storage location, Plant",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a5);

        Question a6 = new Question("You use real-time reconciliation between Controlling (CO) and Financial Accounting (FI) within New General Ledger Accounting. You therefore want to receive a reconciliation posting in FI when you allocate an internal activity between cost centers assigned to different profit centers. How do you fulfill this requirement? There are 2 correct answers to this question.",
                "Select profit center as a characteristic for real-time reconciliation. ",
                "Define a general ledger reconciliation account for direct activity allocation. ",
                "Execute the periodic transfer to Profit Center Accounting. ",
                "Carry out a reconciliation run for activity types in the new general ledger.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a6);

        Question a7 = new Question("Which of the following documents cannot be posted for direct activity allocation? Please choose the correct answer. ",
                "Document manually entered into cost accounting",
                "CO documents for confirmations. ",
                "CO documents for time entry.",
                "Document entered with more than one cost center",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a7);

        Question a8 = new Question("You have defined a variable as global variable & the same is being used in repots. Now some changes had been made to this global variable. Which of the statements are correct? Please choose the correct answer. ",
                "A variable once declared and used cannot be changed ",
                "The changes will affect the report that are using this variable ",
                "No effect will be on the report. ",
                "The changes will affect the report made after the date of the changes.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a8);

        Question a9 = new Question("Your organization is using process order to manufacture their products. Which of the following statements are correct? There are 3 correct answers to this question. ",
                "Master recipe is used which contains operations and phases ",
                "One or more materials is required for execution of that step ",
                "The operations are relevant to costing ",
                "The costs are updated to the order header",
                null,
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a9);

        Question a10 = new Question("You have created statistical key figures in Cost center accounting, and the same is required in profit center accounting. Do we need to maintain the same? There are 2 correct answers to this question. ",
                "Yes we need to maintain the same again in Profit center accounting ",
                "No it is not required",
                "Statistical key figures are created at company code level",
                "Statistical key figures are created at controlling area level",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a10);

        Question a11 = new Question("What do you define when you set up an operating concern for costing-based profitability analysis? There are 3 correct answers to this question. ",
                "Functional area ",
                "Characteristics",
                "Value fields ",
                "Chart of accounts ",
                "Operating concern currency",
                null,
                null, "X", "X", null, "X", null, Question.C_TFIN22_67);
        addQuestion(a11);

        Question a12 = new Question("Your customer wants to see a P&L statement for profit centers by the cost-of-sales-accounting approach. Which of the following is the minimum requirement? Please choose the correct answer. ",
                "Activate profitability analysis. ",
                "Create a derivation rule for the functional area. ",
                "Activate the scenario functional area in New GL. ",
                "Enter the functional area in the profit center master.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a12);

        Question a13 = new Question("Controlling makes use of two different types of controlling objects, True Controlling Objects & Statistical Controlling Objects. Which of the following are Statistical Controlling Objects? There are 3 correct answers to this question. ",
                "Cost Centers (for account assignment of revenues) ",
                "Profit Centers ",
                "Projects",
                "Statistical internal Orders",
                null,
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a13);

        Question a14 = new Question("For which of the following postings to costing-based profitability analysis can you carry out a valuation? There are 2 correct answers to this question. ",
                "For transfer cost center cost by assessment.",
                "For transfer of billing documents. ",
                "For incoming sales orders. ",
                "For activity allocation.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a14);

        Question a15 = new Question("Which of the following terms apply to costing-based profitability analysis? Note: There are 2 correct answers to this question? ",
                "Contribution margin ",
                "Balance sheet statement ",
                "Segment reporting ",
                "Cost of sales accounting",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a15);

        Question a16 = new Question("Which of the following are the functions of drilldown reporting? Please choose the correct answer. ",
                "Navigate to characteristic with drag and drop ",
                "Display several output area one screen ",
                "Navigate to detail list ",
                "All the above",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a16);

        Question a17 = new Question("You carry out a variance calculation on production orders at period-end closing. What reasons could there be for the price variances? There are 2 correct answers to this question.",
                "The activity types were consumed from different cost centers. ",
                "The valuation variants of the standard cost estimates and the production orders are different. ",
                "The consumed materials are defined as moving average price (V). ",
                "The consumed materials have multiple production variants.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a17);

        Question a18 = new Question("What are the organizational entities for which the profit & loss statement and balance sheet can be generated? There are 3 correct answers to this question. ",
                "Company code and profit center ",
                "Profit center and business area",
                "Company code and cost center ",
                "Company code and business area",
                null,
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a18);

        Question a19 = new Question("What are the prerequisites to calculate overhead costs on an internal order? There are 2 correct answers to this question. ",
                "Assign the costing sheet to the costing variant. ",
                "Define an overhead key. ",
                "Define a costing sheet. ",
                "Assign the costing sheet in the order master data.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a19);

        Question a20 = new Question("Which of the following statement are not correct? Please choose the correct answer. ",
                "For accrual cost calculation using the percentage method, you need not create an overhead structure",
                "For accrual calculation using the target=actual or the plan=actual methods, you must create the corresponding accrual cost elements ",
                "For accrual cost calculation using the percentage methods we create overhead structure with following keys i) Calculation bases ii) Overhead percentage rates iii) Credit objects.",
                "The advantage of percentage method over using a recurring entry in the Financial Accounting component (FI) is that accrual is based on the actual costs posted",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a20);

        Question a21 = new Question("n customization for costing based CO-PA we assign costs and revenues to the required value field. Match the following sources of value fields. 1 Cost Estimate i. Fixed Cost of Goods Manufactured 2 WBS Elements ii. Freight costs 3 General ledger Posting iii. Research & development costs 4 Production order iv. Estimated bonuses 5 Additional costs v. Production Variances Please choose the correct answer. ",
                "1-i., 2-iii.,3-ii.,4-v.,5-iv. ",
                "1-iv., 2-ii.,3-iii.,4-v.,5-i. ",
                "1-ii.,2-iii.,3-i.,4-v.,5-iv. ",
                "1-v., 2-iii.,3-ii.,4-v.,5-i",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a21);

        Question a22 = new Question("What are the characteristic of co-products? Please choose the correct answer. ",
                "A co-product is a valuated product that is produced simultaneously with one or more products. ",
                "We specify it in MRP or costing view of material master ",
                "We turn on the co-product indicator.",
                "All the above.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a22);

        Question a23 = new Question("What should you do if you want to carry forward unused funds for an order which has commitment & budget to fiscal year? Please choose the correct answer. ",
                "Change the status of order as closed & create a new order in the next fiscal year.",
                "Carry forward the commitment against the order, the budget will automatically be carried forward ",
                "Carry forward the budget against the order, the commitment will automatically be carried forward ",
                "Carry forward the commitment first against the order, and then carry forward the budget.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a23);

        Question a24 = new Question("You have activated integrated planning from overhead cost controlling to financial accounting for profit center planning. Which of this statement is correct? Please choose the correct answer. ",
                "The plan version in FI and CO need to be same name ",
                "The plan version in FI and CO need not be having same name ",
                "None of the above",
                null,
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a24);

        Question a25 = new Question("How are the production cost derived? Please choose the correct answer. ",
                "Combining data from production planning with cost center Accounting/ Activity-based costing. ",
                "The routing describes the quantity of an activity and the location of the operations. ",
                "The work center describes where an operation is performed. ",
                "It is linked to a cost center to valuate the activities. ",
                "All the above.",
                null,
                null, null, null, null, "X", null, Question.C_TFIN22_67);
        addQuestion(a25);

        Question a26 = new Question("Which of the following statement not correct with reference to revaluation? Please choose the correct answer.",
                "We can increase or decrease planning data on a percentage basis.",
                "We can revaluate cost and amounts. ",
                "We can revaluate all cost elements used in the primary cost element and revenue planning.",
                "We can revaluate assessment cost center, imputed cost elements and cost elements used in indirect activity allocation.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a26);

        Question a27 = new Question("Which of the following can you assign in the profitability analysis transfer structure? Please choose the correct answer. ",
                "Distribution rules to cost elements ",
                "Master data to characteristics ",
                "Cost elements to value fields ",
                "Source cost elements to allocation cost elements",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a27);

        Question a28 = new Question("Which data can be saved when storing a material cost estimate with quantity structure? There are 3 correct answers to this question. ",
                "Log",
                "Cost components split ",
                "Extract",
                "Itemization",
                "Variance categories",
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a28);

        Question a29 = new Question("What is the use of reference and stimulating costing? Please choose the correct answer. ",
                "It is used to calculate a simulated price without material master ",
                "It is used to update the prices of the reference material. ",
                "It is used to create a material costing for simulation. ",
                "It is used to calculate a price for internal activities.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a29);

        Question a30 = new Question("Let say for a product there exists three production versions. There are steps required to create a mixed cost estimate. What are they? Please choose the correct answer. ",
                "Create procurement alternatives for each of the production version. ",
                "Define mixing ratios for the procurement alternatives. ",
                "Select the configured quantity structure type and execute a material cost estimate based on the costing version. ",
                "All the above.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a30);

        Question a31 = new Question("What does the SAP Web AS provide? Please choose the correct answer. ",
                "Real-time data exchange with all SAP systems. ",
                "Master data harmonization cross SAP NetWeaver. ",
                "J2EE and ABAP in a single environment. ",
                "Storage of all transactional documents in one single database.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a31);

        Question a32 = new Question("During market segment planning and sales and profit planning, we can create budgets for sales support measures. How are this data passed on to CO-PA? Please choose the correct answer. ",
                "The condition record is created as a part of sales agreement. ",
                "The sales order is created. ",
                "The billing document is created. ",
                "All the above.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a32);

        Question a33 = new Question("Which sequence of organizational units describes the organizational structure from the top down? Please choose the correct answer. ",
                "Operating concern ->Controlling area ->Company code ->Plant ->Storage location ",
                "Company code -> Operating concern -> Controlling area -> Plant -> Storage location ",
                "Operating concern -> Controlling area -> Company code -> Storage location -> Plant ",
                "Controlling area ->Operating concern ->Company code ->Plant ->Storage location",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a33);

        Question a34 = new Question("Which of the following objects can be assigned to asset master record? Note: There are more than one correct answers to this question. ",
                "Profit center ",
                "Cost center ",
                "Internal order ",
                "WBS element ",
                "Profitability segment",
                null,
                null, "X", "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a34);

        Question a35 = new Question("Excluding the Continuous improvement phase, how many phases are there in the Accelerated SAP roadmap ? Please choose the correct answer. ",
                "4",
                "3",
                "5",
                "6",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a35);

        Question a36 = new Question("Which of the following do you define in the general data selection of a Report Painter report? Please choose the correct answer. ",
                "Parameters valid for all rows and columns. ",
                "Parameters for the report to report interface.",
                "Default values for the definition of rows and columns. ",
                "User, date, and time of report creation.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a36);

        Question a37 = new Question("You want to calculate overhead rates on an internal order. You have already defined the costing sheet. Which of the following assignments must you perform next? Please choose the correct answer. ",
                "Assign the costing sheet to the valuation variant. ",
                "Assign the costing sheet in the order type. ",
                "Assign the costing sheet in the order master data. ",
                "Assign the costing sheet to the costing variant.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a37);

        Question a38 = new Question("How does the decoupling scenario for production orders work when combined with a product cost collector? Please choose the correct answer. ",
                "Costs are posted to the production order and settled to the product cost collector at period-end closing. ",
                "Costs are posted to the product cost collector and posted statistically to the production order. ",
                "Costs are only posted to the product cost collector and not to the production order. ",
                "Costs are posted to the production order and posted statistically to the product cost collector.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a38);

        Question a39 = new Question("What is the advantage of using a key figure scheme in drilldown reports in profitability analysis? Please choose the correct answer.",
                "The key figure scheme allows the calculating of lines with subtotals in a drill down report. ",
                "A key figure scheme allows for simultaneous access to different databases. ",
                "The key figure scheme allows quick access to predefined key figures in the database. ",
                "A key figure scheme improves the runtime of the drilldown report.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a39);

        Question a40 = new Question("You want to enter items in a reference and simulation cost estimate manually. Which item categories can you use? There are 3 correct answers to this question. ",
                "I - Sales order item ",
                "M - Material ",
                "E - Internal activity ",
                "K - Cost center ",
                "B - Base planning object",
                null,
                null, "X", "X", null, "X", null, Question.C_TFIN22_67);
        addQuestion(a40);

        Question a41 = new Question("What are the impacts on an S price controlled material when releasing a material cost estimate? There are 2 correct answers to this question. ",
                "Previous material movements are revaluated. ",
                "Existing stock is valuated with the new price. ",
                "Moving average price is adjusted. ",
                "New standard price is set.",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a41);

        Question a42 = new Question("Your customer wants to use a consistent stock valuation strategy for products in each company code. What are the restrictions for standard price cost estimates? Please choose the correct answer. ",
                "They are only released to material cost estimates with quantity structure. ",
                "They are only released to the material master data. ",
                "They are only released to those estimates that use iterative calculated activity prices.",
                "They are only released to one costing variant per period and company code.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a42);

        Question a43 = new Question("Which of the following statements describe profit centers? There are 3 correct answers to this question. ",
                "Profit centers are the basic organizational units of profitability analysis. ",
                "Profit centers are usually structured in the hierarchy by region, function, or product. ",
                "Profit centers represent an area of responsibility for cost and revenues. ",
                "Profit centers are structured in a standard hierarchy. ",
                "Profit centers are sub-units of cost centers.",
                null,
                null, "X", "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a43);

        Question a44 = new Question("There are different views in material master which are relevant to different functional areas. No. Material Master view No. Attributes of material 1 Accounting view I Material valuation 2 Costing view II Material price control 3 MRP View III Account determination IV Cost object controlling V Scrap factors VI Production version Match the following attributes available in the relevant view. Please choose the correct answer. ",
                "1''I,III, 2''II,IV, 3''V, VI ",
                "1''I,II, 2''III,IV, 3''V,VI ",
                "1''I,II,III , 2''IV, 3''V,VI ",
                "1''II,III , 2''I,IV, 3''V,VI",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a44);

        Question a45 = new Question("You are using document splitting in the new general ledger, & you had assigned a default profit center whenever an account assignment is missing in the item. What will be the result of this assignment? There are 2 correct answers to this question. ",
                "The default profit center is assigned when the derivation of profit center is not possible during the time of posting the documents. ",
                "The default profit center is derived for each transaction. ",
                "You have to distribute this value at the end of this month.",
                "You don''t have to distribute this value at the end of this month.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a45);

        Question a46 = new Question("You need to allocate various expenses booked to a cost center to profit center via assessment. Which of the following statements are correct? Please choose the correct answer. ",
                "You can use secondary cost elements as assessment account.",
                "You can able to trace the original account from the receiving object ",
                "You cannot use secondary cost elements as assessment account. ",
                "None of the above",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a46);

        Question a47 = new Question("Which of the following statement not correct with reference to overhead costing sheets? Please choose the correct answer. ",
                "It allows to differentiate overhead cost rates or amounts by plant.",
                "It allows to differentiate overhead cost rates or amounts by company code. ",
                "It allows to differentiate overhead cost rates or amounts by profit center. ",
                "It allows to differentiate overhead cost rates or amounts by material origin.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a47);

        Question a48 = new Question("Which of the following statement are not correct? Please choose the correct answer. ",
                "For accrual cost calculation using the percentage method, you need not create an overhead structure ",
                "For accrual calculation using the target=actual or the plan=actual methods, you must create the corresponding accrual cost elements ",
                "For accrual cost calculation using the percentage methods we create overhead structure with following keys i) Calculation bases ii) Overhead percentage rates iii) Credit objects.",
                "The advantage of percentage method over using a recurring entry in the Financial Accounting component (FI) is that accrual is based on the actual costs posted",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a48);

        Question a49 = new Question("What status reports does Cash Management and forecasting include? There are 3 correct answers to this question. ",
                "Cash management position ",
                "Liquidity forecast ",
                "Credit limit report ",
                "G/L account balances ",
                "Bill holdings",
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a49);

        Question a50 = new Question("Which steps is not part of indirect activity allocation? Please choose the correct answer. ",
                "Define keys for the automatic periodic allocation of actual activities. ",
                "Segment and cycles are used to define sender and receiver relationships.",
                "The costs are allocated using primary cost element.",
                "The cost element assignment is taken from the master data.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a50);

        Question a51 = new Question("Document splitting allows you to display documents using a differentiated representation. In the representation, line items are split according to selected dimensions. In this way, you can draw up complete financial statements for the selected dimensions at any time. Which of the following functions are part of document splitting? There are 2 correct answers to this question. ",
                "Active document splitting: Splitting a document ",
                "Passive document splitting: Clearing and similar processes ",
                "Statistical document splitting: Reporting processes.",
                "It defines characteristics that can be used by reports contained in a group.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a51);

        Question a52 = new Question("How can you set up segment reporting in the New GL? There are 2 correct answers to this question.",
                "By defining segment master records in the application. ",
                "By assigning segments in the master record of the profit center. ",
                "By assigning segments in the master record of the cost center. ",
                "By activating the scenario segment reporting in the customizing.",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a52);

        Question a53 = new Question("The data flows from sales order management to CO-PA. When data are transferred to account- based controlling profitability analysis, it provides the following features: There are 2 correct answers to this question. ",
                "Data transferred as soon as it is created",
                "It can be always reconciled with FI ",
                "Transferred to cost and revenue elements ",
                "Short term up-to-date data",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a53);

        Question a54 = new Question("Overhead Cost Controlling component enables you to plan, allocate, control, and monitor overhead costs. Which of the following fall under Overhead Cost Controlling? There are 4 correct answers to this question. ",
                "Cost Element Accounting ",
                "Cost Center Accounting ",
                "Internal Orders ",
                "Activity Based Costing ",
                "Plant based Costing",
                null,
                "X", "X", "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a54);

        Question a55 = new Question("When you create an internal order, what is derived from the order type? There are 2 correct answers to this question. ",
                "Controlling area ",
                "Settlement rule ",
                "Settlement profile ",
                "Model or reference order default entries",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a55);

        Question a56 = new Question("What are the period end closing activities for sales order without production i.e. service? There are 2 correct answers to this question. ",
                "Result analysis to calculate the costs and revenues of the cost object ",
                "The revenues and costs of the sales are settled to financial accounting and profit center accounting ",
                "Stocks and reserves are settled to profitability ",
                "Create a debit memo based on CO line items",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a56);

        Question a57 = new Question("You want to define some fields as mandatory in an internal order. How can you achieve this? Please choose the correct answer. ",
                "Adjust the field status variant in the order layout. ",
                "Adjust the field selection in the order type. ",
                "Define the fields as mandatory in the model order. ",
                "Define a user status in the status profile.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a57);

        Question a58 = new Question("Please choose the correct answer. ",
                "Valuation of the planned quantity structure with planned prices. ",
                "Valuation of current quantity structure with planned prices. ",
                "Valuation of current quantity structure with current prices. ",
                "Valuation of actual quantity structure with tax-based and commercial prices ",
                "All the above.",
                null,
                null, null, null, null, "X", null, Question.C_TFIN22_67);
        addQuestion(a58);

        Question a59 = new Question("Which step of the sales from stock process creates the cost of goods sold in costing-based CO-PA? Please choose the correct answer. ",
                "Creating the sales order.",
                "Creating the outbound delivery. ",
                "Creating the billing document.",
                "Creating the transport order.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a59);

        Question a60 = new Question("How does the cost and revenue flow to the profit center? There are 2 correct answers to this question. ",
                "The profit center is assigned to the cost center master data. ",
                "The profit center is assigned to sales order",
                "The profit center is assigned to material master. ",
                "All the above.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a60);

        Question a61 = new Question("Which of the following order types are internal orders? There are 3 correct answers to this question. ",
                "Capital investment orders for creating assets. ",
                "Maintenance orders. ",
                "Sales orders for make-to-order function ",
                "CO production orders.",
                null,
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a61);

        Question a62 = new Question("In costing, a strategy sequence is used to select a vendor or purchasing info record. The selection criteria are as follows: i) Prices of vendors ii) Source list for material. iii) Purchasing info records. iv) Quota arrangement for material. Please choose the correct answer. ",
                "iv, i, ii, iii ",
                "iv, ii, iii, i ",
                "i, iv, ii, iii ",
                "iii, i, ii, iv",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a62);

        Question a63 = new Question("What does the SAP Net Weaver Application Server (SAP Net Weaver AS) provide? Please choose the correct answer ",
                "Real-time data exchange with all SAP systems",
                "Storage of all transactional documents in one single database ",
                "J2EE and ABAP in a single environment ",
                "Master data harmonization across SAP Net Weaver",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a63);

        Question a64 = new Question("Which of the following can you assign in the profitability analysis transfer structure? Please choose the correct answer. ",
                "Distribution rules to cost elements ",
                "Master data to characteristics ",
                "Cost elements to value fields ",
                "Source cost elements to allocation cost elements",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a64);

        Question a65 = new Question("A customer allocates a variety of cost elements from many cost centers to others by distribution cycles. The customer complains about the long duration and runtime. What do you recommend to shorten the runtime? There are 2 correct answers to this question. ",
                "Use cycle run groups for parallel processing. ",
                "Use iteration within the cycles.",
                "Use assessment instead of distribution. ",
                "Use an allocation structure within the distribution cycles.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a65);

        Question a66 = new Question("You want to enter items in a reference and simulation cost estimate manually. Which item categories can you use? There are 3 correct answers to this question. ",
                " I - Sales order item ",
                " M - Material",
                " E - Internal activity ",
                " K - Cost center ",
                " B - Base planning object",
                null,
                null, "X", "X", null, "X", null, Question.C_TFIN22_67);
        addQuestion(a66);

        Question a67 = new Question("You have activated segment reporting for your company code. What is its prerequisite? There are 2 correct answers to this question. ",
                "The segment is derived manually from the company code ",
                "The document splitting procedure is not mandatory",
                "You can define own rule to derive the segment during posting. ",
                "You have to allow zero balances for the segment characteristics",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a67);

        Question a68 = new Question("Which planning transactions create secondary costs on the receivers? There are 2 correct answers to this question. ",
                "Plan assessment ",
                "Transfer of depreciations from Asset Accounting ",
                "Transfer of personnel cost from HR ",
                "Plan distribution ",
                "Activity input planning",
                null,
                "X", null, null, null, "X", null, Question.C_TFIN22_67);
        addQuestion(a68);

        Question a69 = new Question("Your company is implementing SAP SRM and SAP SCM in phase 1. They are planning a phase 2 to include SAP CRM and SAP BI. Their goal is to minimize changes & therefore costs. They ask you for an opinion on when to install the Solution Manager. Please choose the correct answer. ",
                "SAP Solution manager should be implemented between Phase I and Phase II. This would ensure that resources are available. ",
                "SAP Solution manager should be implemented at the beginning of Phase I as it is only used for project planning & configuration via Roadmaps. If we don''t implement it in phase 1 we should not implement it at all. ",
                "SAP Solution manager should be implement at the beginning of Phase I as it can configure to help systems via roadmaps and it is required by SAP for software maintenance of SAP SCM and the other SAP systems in our landscape.",
                null,
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a69);


        Question a71 = new Question("The customer requires a new Report Painter report displaying cost information and statistical key figures in one report. Please choose the correct answer. ",
                "By defining two separate reports and combining them. ",
                "By defining two sections in the report. ",
                "By defining two variants for the report. ",
                "By defining additional rows in the report.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a71);

        Question a72 = new Question("What effect does releasing a material cost estimate have on a material with a standard price (S)? Note: There are 2 correct answers to this question ",
                "Previous material movements are revaluated ",
                "The moving average price is adjusted ",
                "A new standard price is set",
                "The existing stock is valuated with the new price",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a72);

        Question a73 = new Question("Which elements can be used in the row and column definition of a Report Painter report? There are 2 correct answers to this question. ",
                "A combination of characteristics used in the general data selection",
                "A combination of a key figure and restricting characteristic values ",
                "A combination of characteristic values valid for the entire report ",
                "A combination of characteristic values",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a73);

        Question a74 = new Question("A customer wants to allocate overhead costs to a production order. How can the customer achieve that? There are 3 correct answers to this question. ",
                "Use routings and work centers. ",
                "Define an assessment cycle. ",
                "Use a template. ",
                "Use a costing sheet. ",
                "Use indirect activity allocation.",
                null,
                "X", null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a74);

        Question a75 = new Question("There are several master data in CO-PA. This includes Characteristic derivation & valuation. You have been asked to explain the key points of valuation. What are they? There are 2 correct answers to this question. ",
                "Valuation strategies must be assigned to record types, point of valuation and plan versions when applicable to be activated ",
                "It is mandatory. ",
                "It supplements or overwrites certain automatically mapped values. ",
                "It can contain CO-PA costing sheets, sales order management pricing procedures, product cost calls, and user exit calls, in a sequence that can be customized.",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a75);

        Question a76 = new Question("Your customer wants to see a P&L statement for profit centers by the cost-of-sales-accounting approach. Which of the following is the minimum requirement? Please choose the correct answer. ",
                "Activate profitability analysis. ",
                "Create a derivation rule for the functional area. ",
                "Activate the scenario functional area in New GL. ",
                "Enter the functional area in the profit center master.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_67);
        addQuestion(a76);

        Question a77 = new Question("Which planning transactions debit receivers with secondary cost elements? There are 2 correct answers to this question. ",
                "Transfer of depreciations from Asset Accounting ",
                "Activity input planning",
                "Transfer of personnel costs from SAP HCM ",
                "Plan assessment",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_67);
        addQuestion(a77);

        Question a78 = new Question("In variance calculation we are using actual costs as the control costs and planned costs as the target costs. Which target cost version we are using? Please choose the correct answer. ",
                "Target cost version 0''total variance ",
                "Target cost version 1''production variance ",
                "Target cost version 2''planning variance",
                "Target cost version 3''production variance of the period",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a78);

        Question a79 = new Question("The item categories are available for cost planning. The lists are given below. Which of them have been defined wrongly? There are 2 correct answers to this question.. ",
                "F''Internal Activity ",
                "E''External Activity ",
                "L''Subcontracting",
                "M''Material",
                "N''Service",
                null,
                "X", "X", null, null, null, null, Question.C_TFIN22_67);
        addQuestion(a79);

        Question a80 = new Question("For what purpose can you use a statistical internal order? There are 2 correct answers to this question. ",
                "Overhead surcharges. ",
                "Settlement. ",
                "Budget and availability control. ",
                "Cost planning.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a80);

        Question a82 = new Question("What are the prerequisites to calculate overhead costs on an internal order? There are 2 correct answers to this question. ",
                "Assign the costing sheet to the costing variant. ",
                "Define an overhead key. ",
                "Define a costing sheet. ",
                "Assign the costing sheet in the order master data.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_67);
        addQuestion(a82);

        Question a83 = new Question("The production order uses the product cost by period. Which of the following statements are not correct? Please choose the correct answer. ",
                "Work in progress in calculated at target cost ",
                "Cost object hierarchy is not possible",
                "Settlement must be performed by period ",
                "Variances are calculated by the amount lying after deducting of value for material already confirmed, WIP from the actual cost.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a83);

        Question a84 = new Question("You have recommended using frozen data to increase data retrieval speed on some of your routine reports. What are the features of it? There are 2 correct answers to this question. ",
                "The data are stored for all the report. ",
                "It is reporting data that has been \"frozen\" at a particular point of time",
                "It can be generated from the object level or using summarization data or summarizing levels. ",
                "The frozen data can be updated",
                "All the above",
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a84);

        Question a85 = new Question("Management accounting provides information to the different requirements of an organization, what are they? Please choose the correct answer. ",
                "Where the costs are originating. ",
                "The cost incurred in producing a product or providing a service to organization. ",
                "Which market segment is profitable. ",
                "The profitability of individual organizational areas. ",
                "All the above.",
                null,
                null, null, null, null, "X", null, Question.C_TFIN22_66);
        addQuestion(a85);

        Question a86 = new Question("What are the organizational entities for which the profit & loss statement and balance sheet can be generated? There are 3 correct answers to this question. ",
                "Company code and profit center ",
                "Profit center and business area ",
                "Company code and cost center ",
                "Company code and business area",
                null,
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a86);

        Question a87 = new Question("How does the decoupling scenario for production orders in combination with a product cost collector work? Please choose the correct answer. ",
                "All costs are posted to the production order, which settles to the product cost collector. ",
                "Costs are posted to the product cost collector and statistically to the production order. ",
                "Costs are posted to the production order and statistically to the product cost collector. ",
                "Costs are only posted to the product cost collector and not to the production order.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a87);

        Question a88 = new Question("The status of production is PDLV. How the Work in progress going to be calculated? Please choose the correct answer. ",
                "The work in progress is the actual cost to date ",
                "The work in progress is the difference between actual costs and the value of good receipt ",
                "The system does not calculate the work in progress ",
                "The system calculates the variances",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a88);

        Question a89 = new Question("Which of the following is the last step of period-end closing in cost object controlling? Please choose the correct answer. ",
                "Work in progress ",
                "Template allocation ",
                "Results analysis ",
                "Settlement",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a89);

        Question a90 = new Question("When do we use additive costing? Please choose the correct answer. ",
                "When transferring the cost estimates from non-SAP ERP. ",
                "When we want to add know costs to the material cost estimate with quantity structure that are not contained in the quantity structure.",
                "When we can include manual costs for each material price or use only manual costs. ",
                "All the above.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a90);

        Question a91 = new Question("A customer wants to add overhead cost to a material cost estimate with quantity structure, without changing the BOM and routing. Which options does the customer have? There are 2 correct answers to this question. ",
                "Overhead surcharges",
                "Easy cost planning ",
                "Cost element planning ",
                "Template allocation",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a91);

        Question a92 = new Question("How can you credit internal orders at period-end closing? There are 2 correct answers to this question. ",
                "Use periodic reposting. ",
                "Use overhead surcharging. ",
                "Use settlement. ",
                "Use template allocation.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a92);

        Question a93 = new Question("Your company is implementing SAP & Chosen Profit Center Accounting. The Transaction of PCA can be stored in several currencies. Which of the following are not correct? Please choose the correct answer. ",
                "Local Currency. ",
                "Special Profit center accounting currency. ",
                "Transaction currency ",
                "Operating concern currency.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a93);

        Question a94 = new Question("Which of the following needs to be activated in the New GL to implement profit center accounting for all costs and revenues? There are 2 correct answers to this question. ",
                "Scenario profit center update ",
                "Scenario segment reporting",
                "Real-time integration CO/FI ",
                "Document splitting",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a94);

        Question a95 = new Question("What is the difference between distribution and assessments? There are 2 correct answers to this question. ",
                "Distribution can be made for both planned and actual figures; assessments cannot. ",
                "Distributions can be made using statistical key figures; assessments cannot. ",
                "Distributions are used when the original cost information is necessary on the receiver; assessments are used when this information is not necessary on the receiver. ",
                "Distributions are made using the original primary cost elements; assessments are made using secondary cost elements.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_66);
        addQuestion(a95);

        Question a96 = new Question("Which of the following Event based postings updates Orders? There are 3 correct answers to this question. ",
                "General ledger accounts postings ",
                "Creation of Material Reservations ",
                "Goods Receipt ",
                "Good Issue",
                null,
                null,
                "X", null, "X", "X", null, null, Question.C_TFIN22_66);
        addQuestion(a96);

        Question a97 = new Question("Which of the following is defined in the PA transfer structure? Please choose the correct answer. ",
                "Assignment of source cost elements to allocation cost elements. ",
                "Assignment of distribution rules to certain cost elements. ",
                "Assignment of master data to characteristics. ",
                "Assignment of cost elements to value fields.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a97);

        Question a98 = new Question("All the cost incurred in overhead costs controlling can be transferred to CO-PA. Which of the following statement is correct? Please choose the correct answer. ",
                "The cost centers and the business processes that are not allocated to inventory can be transferred using periodic assessment. ",
                "Direct allocation on internal activities for into CO-PA for cost centers and business processes can be done. ",
                "We can use a PA transfer structure to control the secondary cost elements of activity allocation in the value fields. ",
                "All the above.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a98);

        Question a99 = new Question("Which of the following statements are TRUE regarding SAP Solution Manager? There are 2 correct answers to this question. ",
                "It is the same toolset as ASAP ",
                "It is an integrated platform that controls both implementation and operation of the live system",
                "Supports customers in ALL project phases, from creating a blueprint to configuring business processes and testing through support of the live environment ",
                "Can only be used to manage business processes on SAP",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a99);

        Question a100 = new Question("Withing Overhead Cost Controlling activities are calculated. A Sender/Receiver relationship exists. However, not all Sender/Receiver combinations are allowed. Which of the following combinations make business sense? Please choose the correct answer. ",
                "Sender - Cost Center, Order, Project Receiver - Cost Center, Order, Project ",
                "Sender - Order Receiver - Cost Center, Project ",
                "Sender - Cost Center Receiver - Cost Center, Order, Project, Cost Object ",
                "Sender - Cost Object Receiver - Cost Center, Order, Project, Cost Object",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a100);

        Question a101 = new Question("What are the steps to be taken before we execute an actual costing run? I. Calculate overheads, do a variance calculation and settle the production order. II. Execute actual activity price calculation. III. Execute all the allocation cycles in the cost center accounting module. IV. Revalue all the production orders with the actual activity prices. Please choose the correct answer. ",
                "IV,II, I, III ",
                "I,II, IV, III ",
                "IV,III, II, I ",
                "III, II, IV, I",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a101);

        Question a102 = new Question("Which of the following statement is correct with reference to assessment? Please choose the correct answer. ",
                "Allocation of Primary and secondary costs from a sender to receiver controlling object. ",
                "Classifying specific activities provided by a cost center along the cost allocation lines. ",
                "Allocation of amounts within CO across company codes.",
                "Activating plan integration with orders and projects.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a102);

        Question a103 = new Question("You are not able to create preliminary cost estimate for the product cost collector. What could be the reason? Please choose the correct answer. ",
                "You are using controlling level ''production version'' ",
                "You are using controlling level ''BOM/Routing'' ",
                "You are using controlling level ''production Plant/planning plant'' ",
                "None of the above",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a103);

        Question a104 = new Question("You are using product cost by order. Which of the following statements are correct? Please choose the correct answer. ",
                "The settlement rule has the settlement type PER ",
                "For period-end closing a result analysis is performed",
                "Setup cost is very low ",
                "Controlling by individual production lots",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a104);

        Question a105 = new Question("To which organizational level do you have to assign the valuation area to create material costings? Please choose the correct answer. ",
                "Controlling area ",
                "Company code ",
                "Business area ",
                "Plant",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a105);

        Question a106 = new Question("Which of the following statement not correct with reference to revaluation? Please choose the correct answer. ",
                "We can increase or decrease planning data on a percentage basis. ",
                "We can revaluate cost and amounts. ",
                "We can revaluate all cost elements used in the primary cost element and revenue planning.",
                "We can revaluate assessment cost center, imputed cost elements and cost elements used in indirect activity allocation.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a106);

        Question a107 = new Question("Which of the following statement is true in reference to Financial & Management Accounting? Please choose the correct answer. ",
                "Financial accounting is for internal management whereas Management accounting is for external management like stockholders, financial institutions, government & tax authorities. ",
                "Management accounting is made on the line of standard & legal requirement whereas financial accounting is made as per the internal requirement of the organization. ",
                "Financial accounting is standard as per legal requirement whereas management accounting is flexible& as per the requirement of the management.",
                "Financial accounting reflects the revenue, cost involved in different area whereas management accounting reflects the profitability of the business.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a107);

        Question a108 = new Question("Periodic reposting.... There are 2 correct answers to this question. ",
                "Allocate the cost to corresponding management accounting object ",
                "We can post primary as well as secondary costs ",
                "The original cost element remains the same during the periodic reposting. ",
                "Periodic repostings cannot be reversed.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a108);

        Question a109 = new Question("SAP provides scenarios which have to be assigned to general ledger accounting. How many scenarios are provided by SAP? Please choose the correct answer. ",
                "12",
                "10",
                "6",
                "1",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a109);

        Question a110 = new Question("What are the steps involved before we run a cost estimate for a split valuated material? There are 2 correct answers to this question. ",
                "Create procurement alternatives based on material type.",
                "Create procurement alternatives based on valuation type for material. ",
                "Maintain mixing ratios for the procurement alternatives. ",
                "All the above.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a110);

        Question a111 = new Question("You have been asked to explain the assignment of profit center to a sales order item. Which of this is not correct? Please choose the correct answer.",
                "The profit center is taken from the customer master record ",
                "The profit center is derived from the material master ",
                "The profit center can be manually assigned for sales order ",
                "The profit center can be set with a substitution based on different fields like business area, plant, storage location, sales area, sales group etc.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a111);

        Question a112 = new Question("You want to calculate overhead rates on an internal order. You have already defined the costing sheet. Which of the following assignments must you perform next? Please choose the correct answer. ",
                "Assign the costing sheet to the valuation variant. ",
                "Assign the costing sheet in the order type. ",
                "Assign the costing sheet in the order master data. ",
                "Assign the costing sheet to the costing variant.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a112);

        Question a113 = new Question("How are the production cost derived? Please choose the correct answer. ",
                "Combining data from production planning with cost center Accounting/ Activity-based costing. ",
                "The routing describes the quantity of an activity and the location of the operations. ",
                "The work center describes where an operation is performed. ",
                "It is linked to a cost center to valuate the activities.",
                "All the above.",
                null,
                null, null, null, null, "X", null, Question.C_TFIN22_66);
        addQuestion(a113);

        Question a114 = new Question("What are the typical sequences for planning activities? i. Plan cost automatically ii. Plan primary cost manually iii. Period lock iv. Plan activity outputs and prices v. Plan statistical key figures Please choose the correct answer. ",
                "v, iii , iv, ii ,I ",
                "i, iii , iv, ii , v ",
                "iii, v, , iv, ii ,I",
                "v, iv , ii , i, iii ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a114);

        Question a115 = new Question("The above entries were made for purchase of services in finance, but when we call up a balance sheet and profit & loss statement, the system display the amount of 50 Euro on the activities purchase account, but no entry for business area, a functional area, a profit center is displayed. What is the reason? Please choose the correct answer. ",
                "The assignment of scenarios, to General ledger is missing ",
                "The assignment of scenarios, to Controlling area is missing ",
                "The assignment of scenarios, to Company code is missing",
                "The assignment of scenarios, to Business area is missing",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a115);

        Question a116 = new Question("You want to add overhead costs to a material cost estimate with quantity structure without changing the bill of material (BOM) and routing. Which options do you have? There are 2 correct answers to this question. ",
                "Template allocation ",
                "Overhead surcharges ",
                "Cost element planning ",
                "Easy Cost Planning",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a116);

        Question a117 = new Question("You have created a production order with order quantity for 500kgs. During the month 200kgs of goods has been produced. What will be the system treatment at month end? Please choose the correct answer. ",
                "The system calculates variance for the quantity which has been produced",
                "The system calculates work in progress for 300kgs remaining in the production order ",
                "The system calculates work in progress for 500kgs ",
                "The system does not calculate work in progress for the production order",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a117);

        Question a118 = new Question("Which of the following characteristics can you use to navigate in a CO-PA drilldown report? Please choose the correct answer. ",
                "Characteristics assigned to SAP NetWeaver Business Warehouse (SAP NetWeaver BW) ",
                "Characteristics of the operating concern ",
                "Characteristics in the field catalog ",
                "Characteristics assigned to a reporting library",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a118);

        Question a119 = new Question("Which of the following statement are correct with reference to group costing? There are 2 correct answers to this question. ",
                "It generates parallel cost component splits for each material with the value added by each partner in the production process. ",
                "No separate cost component split is generated for each partner. ",
                "It can be used even if all companies are not assigned to the same controlling area. ",
                "It shows the contribution of each profit center and business unit to product costs.",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a119);

        Question a120 = new Question("Posting of costs and revenue to CO can result in real or statistical postings, which of the following statement are correct? Please choose the correct answer. ",
                "One and only one real posting is required in CO ",
                "Real postings are for information purpose only. ",
                "Statistical postings can be settled or allocated to other CO objects. ",
                "Statistical posting contains the information that is transferred to financial accounting for reconciliation.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a120);

        Question a121 = new Question("How would you explain a market segment in CO-PA? What is a market segment in COPA? ",
                "A certain value combination of the defined characteristics. ",
                "A predefined value combination for the characteristics delivered by SAP. ",
                "A certain combination of the defined characteristics and value fields. ",
                "A certain characteristic combination of predefined values.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a121);

        Question a122 = new Question("Where do you determine the price finding strategy for material costing? ",
                "Valuation variant ",
                "Price control ",
                "Price determination ",
                "Valuation class",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a122);

        Question a123 = new Question("Which data sources can be included directly into service level reports in SAP Solution Manager?(Choose two) ",
                "Solution Manager BW ",
                "Wily Introscope Enterprise Manager ",
                "Early Watch Alert",
                "Implementation projects",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a123);

        Question a124 = new Question("Which of the following are valid assignments between company code and controlling area? (Choose two) ",
                "One company code to one controlling area (1:1). ",
                "One company code to multiple controlling areas (1:n). ",
                "Multiple company codes to one controlling area (n:1). ",
                "Multiple company codes to multiple controlling areas (n:n).",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a124);

        Question a125 = new Question("When settling an investment order for an unfinished asset, the customer, by law, needs to settle the order to an asset under construction (AuC). How can this be accomplished in the system?",
                "Set up an appropriate investment reason and a threshold for scale level and assign both to the order. ",
                "Set up an assessment cycle to allocate the costs of the investment order to the previously created AuC. ",
                "Assign a settlement rule to AuC directly to the position of the investment program. ",
                "Set up the investment profile to use the AuC of a certain asset class and assign it to the used order type.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a125);

        Question a126 = new Question("Scenario Profit Center Update with real time integration is activated in the New GL. How is the profit center information stored in financial postings to a CO object? ",
                "In a separate profit center accounting document. ",
                "In a separate field in the New GL document.",
                "In a reconciliation ledger document. ",
                "In a separate New GL document.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a126);

        Question a127 = new Question("A company wants to use Profitability Analysis (CO-PA) to obtain an early analysis of their anticipated profits. Which functionality provides the best results? ",
                "Transfer the plan balance data from Fl to account-based CO-PA and use record type \"F\" for analysis. ",
                "Analyze sales quotation as a detail value. ",
                "Transfer the plan data from the \"Sales and operation planning\" to costing-based CO-PA and use record type \"P\" for analysis. ",
                "Transfer sales orders and quotations from SD to costing-based CO-PA and use record type \"A\" for analysis. ",
                "Transfer sales orders and quotations from SD to account-based CO-PA and use record type \"F\" for analysis.",
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a127);

        Question a128 = new Question("How does material costing support semi-finished and finished materials that are valuated in stock with consistent valuation strategies per company code? ",
                "Costing runs to update the standard prices have to run generally under observation of an external auditor. ",
                "You are only allowed to use one single costing variant to update standard prices per period and company code. ",
                "You are only allowed to use iterative activity prices in material cost estimates which update standard prices. ",
                "You are only allowed to use material cost estimates with quantity structure to update standard prices.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a128);

        Question a129 = new Question("The customer requires a flexible selection of cost elements when starting a Report Painter report. How do you define the report? ",
                "Using a row model with predefined key figures. ",
                "Using a variable for the cost element group. ",
                "Using a predefined report template. ",
                "Using a variable for the report variant.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a129);

        Question a130 = new Question("Which step of the sales from stock process creates the cost of goods sold in costing-based CO-PA? ",
                "Creating the billing document. ",
                "Creating the transport order. ",
                "Creating the outbound delivery. ",
                "Creating the sales order.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a130);

        Question a131 = new Question("Which information is transferred when you settle an Internal Order to costing-based COPA? ",
                "Cost component split of the order cost. ",
                "Characteristic values of the settlement rule. ",
                "Variance categories of the internal order.",
                "All information of the internal order master data.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a131);

        Question a132 = new Question("For what purpose can you use a statistical internal order?(Choose two) ",
                "Overhead surcharges. ",
                "Settlement. ",
                "Budget and availability control. ",
                "Cost planning.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_66);
        addQuestion(a132);

        Question a133 = new Question("Your customer wants to see a P&L statement for profit centers by the cost-of-salesaccounting approach. Which of the following is the minimum requirement? ",
                "Activate profitability analysis. ",
                "Create a derivation rule for the functional area.",
                "Activate the scenario functional area in New GL.",
                "Enter the functional area in the profit center master.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a133);

        Question a134 = new Question("A customer is producing materials according to planned independent requirements. At what time during the make-to-stock process is the requirement consumption of a new sales order item visible in the system? ",
                "After creating the delivery ",
                "After posting goods issue ",
                "After saving the order ",
                "After a new planning run",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a134);

        Question a135 = new Question("You have completed the basic configuration of SAP Solution Manager and defined the solution landscape. Which of the following scenarios will work without further configuration steps?(Choose two) ",
                "Business Process and Interface Monitoring ",
                "Early Watch Alert ",
                "Change Request Management ",
                "Maintenance Optimizer",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a135);

        Question a136 = new Question("A customer wants to add overhead cost to a material cost estimate with quantity structure, without changing the BOM and routing. Which options does the customer have?(Choose two) ",
                "Overhead surcharges ",
                "Easy cost planning ",
                "Cost element planning ",
                "Template allocation",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a136);

        Question a137 = new Question("What options are provided by SAP Business Warehouse (SAP BW) when creating financial reports?(Choose two)",
                "You can display an analysis in Microsoft Access using the Business Explorer viewer. ",
                "You can display an analysis on the Web using Enterprise Portal and BEx Web Analyzer. ",
                "You can convert a Microsoft Excel pivot table query into an SAP BW report. ",
                "You can export a Web report to a BEx Web Analyzer report.",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a137);

        Question a138 = new Question("Which function do you use to transfer a cost component split that has been calculated in a sales order cost estimate to Profitability Analysis? ",
                "Product cost estimate ",
                "Planned cost estimate ",
                "Unit cost estimate ",
                "Additive cost estimate",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a138);

        Question a139 = new Question("What is the maximum number of function modules you can assign to a single follow-up action for the usage decision in the Implementation Guide (IMG)? ",
                "Zero",
                "Ninety-nine ",
                "Unlimited",
                "One",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a139);

        Question a140 = new Question("Where do you have to assign the costing sheet to enable overhead surcharging for material costing? ",
                "Costing version ",
                "Material master ",
                "Material cost estimate ",
                "Costing variant",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a140);

        Question a141 = new Question("A certain cost element has conflicting cost center assignments in the Default Account Assignment field (cost element master data) and in the Automatic Account Assignment table (IMG). What happens when a document is posted with this cost element? ",
                "The Automatic Account Assignment (IMG) has a higher priority. ",
                "An error message is displayed. ",
                "The system prompts you in a dialog box. ",
                "The Default Account Assignment (cost element master data) has a higher priority.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a141);

        Question a142 = new Question("A customer is using sales order controlling. How are the revenues and cost of goods sold transferred to CO-PA? ",
                "By results analysis. ",
                "By settlement. ",
                "By billing. ",
                "By outbound delivery",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a142);

        Question a143 = new Question("Why do you use variants in reporting?(Choose two) ",
                "To specify parameter values for background processing.",
                "To optimize the runtime of a report. ",
                "To predefine values for complex selection screens. ",
                "To permit quick navigation between CO objects.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a143);

        Question a144 = new Question("A company asks for a real-time sales report to analyze Revenue by Customer Group, by Sales Organization, by Product that allows for navigation to sales order line items. What reports can provide this information?(Choose two) ",
                "Drilldown report based on line items for Costing-Based Profitability Analysis. ",
                "Drilldown Basic Report for Profit Center Accounting. ",
                "Drilldown Basic Report for Account-Based Profitability Analysis. ",
                "Form Report for Profit Center Accounting.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a144);

        Question a145 = new Question("A customer wants to define some fields as mandatory in an internal order. How can the customer achieve this? ",
                "By adjusting the field selection in the order type. ",
                "By defining an appropriate selection variant. ",
                "By indicating the fields as mandatory in the model order. ",
                "By adjusting the field status variant.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a145);

        Question a146 = new Question("Which are the necessary steps to create a validation? ",
                "Prerequisite, check, message ",
                "Check, control, message ",
                "Check, update, message ",
                "Prerequisite, check, update, control",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a146);

        Question a147 = new Question("Which of the following organizational units are maintained in Management Accounting?(Choose two) ",
                "Controlling area ",
                "Operating concern ",
                "Company code ",
                "Business area ",
                "Functional area",
                null,
                "X", "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a147);

        Question a148 = new Question("Which of the following processes changes the acquisition value of an asset? ",
                "Retirement of the asset ",
                "Change of the depreciation key of the asset ",
                "Unplanned depreciation of the asset ",
                "Change of the useful life of the asset",
                null,
                null,
                null, "X", "X", "X", null, null, Question.C_TFIN22_66);
        addQuestion(a148);

        Question a149 = new Question("Which step in the sales from stock process creates the cost of goods sold in Costing-based Profitability Analysis (CO-PA)? ",
                "Billing",
                "Outbound delivery",
                "Creation of the transport order ",
                "Creation of the sales order",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a149);

        Question a150 = new Question("Which of the following views and results does costing based CO-PA provide?(Choose two) ",
                "Balance sheet statement. ",
                "Return on investment.",
                "Contribution margin. ",
                "Periodic accounting. ",
                "Cost of sales accounting.",
                null,
                null, null, "X", null, "X", null, Question.C_TFIN22_66);
        addQuestion(a150);

        Question a151 = new Question("The system does not allow you to create a primary cost element. What do you check first? ",
                "Whether the P/L account exists ",
                "Whether the cost element category is valid ",
                "Whether the balance sheet account exists",
                "Whether the 6/L account currency is the same as the controlling area currency",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a151);

        Question a152 = new Question("How can you credit internal orders at period-end closing?(Choose two) ",
                "Use periodic reposting. ",
                "Use overhead surcharging. ",
                "Use settlement. ",
                "Use template allocation.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a152);

        Question a153 = new Question("How can you use resource related billing for sales order items? ",
                "Assign production orders with BOMs and routings.",
                "Use a Requirement class with an indicator set for resource related billing. ",
                "Use Easy Cost Planning and Execution Services.",
                "Assign Dynamic Item Processor (DIP) profiles.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a153);

        Question a154 = new Question("Your New GL customer uses real-time reconciliation of CO and FI. The customer wants to show the value flow of activity allocations between cost centers assigned to different profit centers. What does the customer have to configure?(Choose two) ",
                "Execute the periodic transfer to profit center accounting.",
                "Define a G/L reconciliation account for direct activity allocation. ",
                "Select profit center as a characteristic for real time reconciliation between CO and FI. ",
                "Carry out a reconciliation run for activities types in the new GL.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a154);

        Question a155 = new Question("The purpose of SAP Solution Manager is to smoothly integrate various SAP solutions to achieve which of the following? (Choose four) ",
                "Faster internet access ",
                "Optimal access to support",
                "Faster issue resolution ",
                "Faster implementation ",
                "Optimal support for operations",
                null,
                null, "X", "X", "X", "X", null, Question.C_TFIN22_66);
        addQuestion(a155);

        Question a156 = new Question("Which of the following do you define in a library of the Report Painter? ",
                "Report groups and reports. ",
                "Formats and format figures. ",
                "Predefined columns and rows. ",
                "Characteristics and key figures.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a156);

        Question a157 = new Question("What does the SAP Web AS provide? ",
                "Real-time data exchange with all SAP systems. ",
                "Master data harmonization cross SAP NetWeaver. ",
                "J2EE and ABAP in a single environment. ",
                "Storage of all transactional documents in one single database.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a157);

        Question a158 = new Question("A customer is missing the values for commitments for internal orders. Where does the customer have to activate Commitment Management to get these values?(Choose two) ",
                "In the order type. ",
                "In the original order budget. ",
                "In the controlling area. ",
                "In the original order budget.",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a158);

        Question a159 = new Question("Which information is transferred when you settle an Internal Order to costing-based COPA? ",
                "Cost component split of the order cost. ",
                "Characteristic values of the settlement rule. ",
                "Variance categories of the internal order. ",
                "All information of the internal order master data.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a159);

        Question a160 = new Question("Which of the following support services can you directly access via the SAP Service Marketplace (http://service.sap.com)? ",
                "Online conferencing with experts on demand ",
                "Execute the SAP remote installation service ",
                "System access to SAP hosted solutions ",
                "Download SAP upgrade guides",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_66);
        addQuestion(a160);

        Question a161 = new Question("In New GL, how would you incorporate companies with different fiscal years if you wanted to assign them to the same controlling area? ",
                "Use the same fiscal year variant for all company codes and set up parallel accounting for company codes that have different fiscal years. ",
                "Create company codes with different fiscal year variants and assign them to the same group company for reporting purposes. ",
                "Create company codes with the same fiscal year variant and assign the company codes that have a different fiscal year to non-leading ledgers with the appropriate fiscal year variant. ",
                "Use the same fiscal year variant for all company codes and do a reversible close for the company codes that have different fiscal years.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_66);
        addQuestion(a161);

        Question a162 = new Question("Where do you have to activate commitment management to enable posting commitments on cost centers? ",
                "Cost center master record ",
                "Controlling area ",
                "Standard hierarchy ",
                "Cost element master record",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_66);
        addQuestion(a162);

        Question a163 = new Question("Which applications are integrated with variant configuration in SAP ERP?(Choose three) ",
                "ERP Quality Management (QM)",
                "ERP Finance (Fl) ",
                "Internet Pricing and Configurator (IPC) ",
                "ERP Pricing (SD) ",
                "ERP Costing (CO)",
                null,
                null, null, "X", "X", "X", null, Question.C_TFIN22_64);
        addQuestion(a163);

        Question a164 = new Question("A customer wants to settle an internal order to cost centers, but receives an error message. What do you check? ",
                "The system and the user status. ",
                "The sender and receiver to be assigned to the same profit center. ",
                "The PA transfer structure of the order. ",
                "The costing sheet.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a164);

        Question a165 = new Question("Which of the following are interactive functions available in the SAP List Viewer There are 3 correct answers to this question. ",
                "Dual control. ",
                "Sorting. ",
                "Summation. ",
                "Master data modification",
                "D Filters.",
                null,
                null, "X", "X", null, "X", null, Question.C_TFIN22_64);
        addQuestion(a165);

        Question a166 = new Question("A customer needs an error message to be displayed when the internal order budget has been exceeded by 15%. How can the customer achieve this?(Choose two) ",
                "By entering the budget profile in the order type. ",
                "By customizing the tolerance limits for the budget profile. ",
                "By activating availability control in the controlling area. ",
                "By entering the budget profile in the order master data.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a166);

        Question a167 = new Question("A customer wants to perform results analysis on sales orders and needs two different methods for different accounting principles (for example, US-GAAP, IFRS). How can the customer achieve this? ",
                "Use two requirement classes in the sales order item. ",
                "Use two results analysis keys in the sales order item. ",
                "Use two results analysis versions in the IMG ",
                "Use two separate sales order items.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a167);

        Question a168 = new Question("A service company decides to implement Activity-Based Costing. They collect all processrelated cost on ABC processes and want to allocate them periodically to their sales orders in Sales Order Management. Which functionality do you implement? ",
                "Process assessment cycles ",
                "Process settlement ",
                "Template allocation technique ",
                "Indirect process allocation",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a168);

        Question a169 = new Question("A customer considers implementing valuated project stock. Which are the benefits of the valuated project stock? ",
                "The inventory in a project stock always shows the same valuation as in the common stock of the material. ",
                "At period-end closing; the inventory in a valuated project stock is additionally posted as work in process on the project. ",
                "The valuated project stock is simple to handle because there is always only one per project. ",
                "Creating an inventory will result in an inventory posting instead of a cost posting.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a169);

        Question a170 = new Question("How can you achieve periodic controlling when a lot size based production scenario is used by logistics?(Choose two) ",
                "Adjust the default rule in the default values for the production order type.",
                "Use an internal order in addition to the production order.",
                "Use a product cost collector in addition to the production order. ",
                "Adjust the costing type of the plan costing variant.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a170);

        Question a171 = new Question("What planning options do you have on internal orders?(Choose three) ",
                "Activity output planning ",
                "Easy cost planning ",
                "Overall planning ",
                "Unit cost estimate ",
                "Top-down planning for order hierarchies",
                null,
                null, "X", "X", "X", null, null, Question.C_TFIN22_64);
        addQuestion(a171);

        Question a172 = new Question("Which object has to be used to avoid a change of the reconciliation account in the customer's master data? ",
                "The field status of the customer account group",
                "The field status group of the reconciliation account. ",
                "The field status of the activity ",
                "The field status of the posting key.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a172);

        Question a173 = new Question("Many of a company's customers regularly pay less than is charged on their bills, or fail to pay their bills at all. Along with normal dunning letters, the company uses a manual, not IT- based process, to track and resolve these cases. Which application would you recommend to improve the processing of accounts receivable and to reduce outstanding invoices? ",
                "SAP Cash Management ",
                "SAP Credit Management ",
                "SAP Billing Consolidation ",
                "SAP Collections and SAP Dispute Management",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a173);

        Question a174 = new Question("Which of the following do you define in the general data selection of a Report Painter report? ",
                "Parameters valid for all rows and columns.",
                "Parameters for the report to report interface. ",
                "Default values for the definition of rows and columns. ",
                "User, date, and time of report creation.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a174);

        Question a175 = new Question("Which SAP Solution Manger Service Desk interfaces are available?(Choose three)",
                "SAP Solution Manager Trace Analysis ",
                "SAP global support backbone ",
                "Managed SAP systems",
                "SAP NetWeaver Administration (NWA) ",
                "Third-party service desk tool",
                null,
                null, "X", "X", null, "X", null, Question.C_TFIN22_64);
        addQuestion(a175);

        Question a176 = new Question("Which of the following allocation methods in cost center accounting use secondary cost elements?(Choose three) ",
                "Activity allocation ",
                "Periodic reposting ",
                "Distribution",
                "Overhead surcharges ",
                "Assessment",
                null,
                "X", null, null, "X", "X", null, Question.C_TFIN22_64);
        addQuestion(a176);

        Question a177 = new Question("A customer wants you to explain the results of the preliminary costing of a production order. How are the results determined?",
                "The actual quantities are valuated with plan values. ",
                "The costs are determined by the cost estimate of the reference order. ",
                "The standard cost estimate is copied from the material master and adjusted by the order quantity. ",
                "The quantity structure in the production order is valuated by the costing variant settings.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a177);

        Question a178 = new Question("Which postings can be triggered by the settlement of a production order?(Choose three) ",
                "Variance categories to profit centers. ",
                "Work in Process (WIP) to FI. ",
                "Variance categories to profitability analysis. ",
                "Balance of the production order to FI. ",
                "Work in Process (WIP) to profitability analysis.",
                null,
                null, "X", "X", "X", null, null, Question.C_TFIN22_64);
        addQuestion(a178);

        Question a179 = new Question("Which of the following management accounting (CO) components requires an operating concern? ",
                "Profit Center Accounting ",
                "Overhead Cost Controlling ",
                "Product Cost Accounting ",
                "Profitability Analysis",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a179);

        Question a180 = new Question("What are the advantages of a real internal order compared to a statistical order? (Choose two) ",
                "Overhead surcharges collection ",
                "Budget and availability control ",
                "Settlement splitting to different receivers ",
                "Exception reporting",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a180);

        Question a181 = new Question("You post goods to storage location A. You notice that documents are missing, so you decide that the goods should not be used any further for the time being. The missing documents turn up at a later stage and you proceed with the respective posting. The goods are subsequently moved from storage location A to storage location B, which you also record in the system. In what sequence are the three goods movements carried out? Select the correct answer. ",
                "Goods receipt - transfer posting - goods issue ",
                "Goods receipt - transfer posting - stock transfer ",
                "Goods receipt - stock transfer - transfer posting ",
                "Goods receipt - transfer order - goods issue",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a181);

        Question a182 = new Question("A customer complains that in various Fl postings both fields, cost center and internal order, are mandatory. Which setting causes these two fields to be mandatory? ",
                "Both cost center and internal order have accidentally been maintained in the default account assignment (OKB9). ",
                "The field \"order\" has accidentally been maintained in the master of the respective cost elements (tab \"default account assignment\"). ",
                "The field \"actual posted cost center\" has accidentally been maintained in the master of the respective internal order (tab \"control data\"). ",
                "Both cost centers and internal orders have accidentally been set to \"mandatory\" in the \"status variant\" field (group \"additional account assignment\").",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a182);

        Question a183 = new Question("How can you separate vendor payments for construction advances from regular down payments? ",
                "Configure a new vendor account group and assign construction advance vendors to it. ",
                "Perform a separate payment run for payment of construction advances. ",
                "Make regular down payments, open them for update, and flag them as down payments. ",
                "Create and use a Special General Ledger indicator for construction advances.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a183);

        Question a184 = new Question("Which planning transactions create secondary costs on the receivers? (Choose two) ",
                "Plan assessment ",
                "Transfer of depreciations from Asset Accounting ",
                "Transfer of personnel cost from HR ",
                "Plan distribution ",
                "Activity input planning",
                null,
                "X", null, null, null, "X", null, Question.C_TFIN22_64);
        addQuestion(a184);

        Question a185 = new Question("A customer wants to allocate internal and external costs, based on statistical key figure values, to the receivers. Which method do you choose? ",
                "Assessment",
                "Overhead calculation ",
                "Distribution",
                "Settlement",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a185);

        Question a186 = new Question("A company in a high-inflation country wants to valuate their finished products with actual costs reflecting all the latest price variances. Which method do you recommend? ",
                "Use actual price determination in the material ledger ",
                "Use lowest-value determination of raw materials. ",
                "Activate FIFO valuation in the special ledger ",
                "Valuate all materials with LIFO valuation.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a186);

        Question a187 = new Question("What are the names of the process hierarchy levels in SAP Solution Manager? ",
                "Business Processes, Business Process Step, Activities ",
                "Business Process Maps, Business Scenarios, Business Processes ",
                "Business scenarios, Business Processes, Activity Steps ",
                "Business Scenarios, Business Processes, Business Process Steps",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a187);

        Question a188 = new Question("How do you receive the internal activities in the material cost estimate using a logistic quantity structure? ",
                "Assign the responsible cost center and its activities directly to the routing header.",
                "Assign a cost center and its activities in the work center of the routing operation. ",
                "Assign a cost element with type 43 (internal activity allocation) to the routing operation. ",
                "Assign a cost center and its activities to the bill of material.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a188);

        Question a189 = new Question("Which SAP NetWeaver component realizes cross-system application processes? ",
                "SAP Enterprise Portal (SAP EP) ",
                "SAP Business Warehouse (SAP BW) ",
                "SAP Exchange Infrastructure (SAP XI) ",
                "SAP Process Integration (SAP PI) ",
                "SAP Master Data Management (SAP MDM)",
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a189);

        Question a190 = new Question("Which of the following are correct descriptions of profit centers? (Choose three) ",
                "Profit centers are the basic organizational units of profitability analysis. ",
                "Profit centers are sub units of cost centers.",
                "Profit centers represent an area of responsibility for cost and revenues. ",
                "Profit centers are structured in a standard hierarchy. ",
                "Profit centers are usually structured in the hierarchy by region, function or product.",
                null,
                null, null, "X", "X", "X", null, Question.C_TFIN22_64);
        addQuestion(a190);

        Question a191 = new Question("Which of the following is the typical sequence of steps in an ASAP roadmap? ",
                "Business blueprint -> Project preparation -> Final preparation -> Realization -> Go-live and support ",
                "Project preparation -> Final preparation -> Business blueprint -> Realization -> Go-live and support ",
                "Project preparation -> Business blueprint -> Realization -> Final preparation -> Go-live and support ",
                "Project preparation -> Realization -> Business blueprint -> Final preparation -> Go-live and support",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a191);

        Question a192 = new Question("A company requests CO-PA reports with more detailed information. Which methods help to achieve more details in the CO-PA cost analysis?(Choose two) ",
                "Refine the asset valuation area settings and the account determination logic for assets. ",
                "Refine the cost component structure in CO-PC and optimize the assignment to value fields. ",
                "Define a cost splitting structure in the overhead surcharges to different characteristics in CO-PA. ",
                "Use an allocation structure in the assessment cycle to CO-PA to assign different cost elements to different value fields",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a192);

        Question a193 = new Question("A company wants to prevent postings of more than 5000 EUR on cost centers by generating an error message. What do you recommend? ",
                "Activating and using availability control for cost centers. ",
                "Creating a substitution rule in the IMG. ",
                "Creating a lock amount on the control tab in the cost center master data. ",
                "Creating a validation rule in the IMG.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a193);

        Question a194 = new Question("For which of the following objects can you use a standard movement type to post a goods issue directly from the valuated stock?(Choose three) ",
                "Profit center ",
                "Project (WBS element) ",
                "Work center ",
                "Cost center ",
                "Production order",
                null,
                null, "X", null, "X", "X", null, Question.C_TFIN22_64);
        addQuestion(a194);

        Question a195 = new Question("Indentify the benefits of SAP Solution Manager. (Choose five) ",
                "More leverage from IT investments ",
                "More Reliable IT solutions. ",
                "Reduced cost of operation ",
                "Reduced ROI ",
                "Faster ROI ",
                "Reduced cost of implementation",
                "X", "X", "X", null, "X", "X", Question.C_TFIN22_64);
        addQuestion(a195);

        Question a196 = new Question("What language is selected for print correspondence to business partners (such as dunning notice, individual letters, balance confirmations, and payment notices? ",
                "The language of the country maintained in the vendor or customer master data ",
                "The language assigned to the accounting clerk maintained in the vendor or customer master data ",
                "The language maintained in the vendor or customer master data ",
                "The user's log-on language",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a196);

        Question a197 = new Question("Which field in the material master determines if the value of the material stock changes when releasing a cost estimate for this material? ",
                "Valuation class ",
                "Price determination ",
                "Price control ",
                "Valuation type",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a197);

        Question a198 = new Question("What runtime environments are provided by SAP NetWeaver?(Choose two) ",
                "WebSphere AS ",
                "Apache Tomcat ",
                "ASABAP",
                "AS Java ",
                "Boss AS",
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_64);
        addQuestion(a198);

        Question a199 = new Question("The management of an international company perceives the implementation of SAP ECC 6.0 with the New General Ledger Accounting as an opportunity to standardize their global processesand still be in compliance with statutory local reporting. What are some of the key design decisions that support their global requirements?(Choose three) ",
                "They should design one leading ledger and one non-leading ledger to capture parallel accounting reporting requirements. ",
                "They should adopt a master data governance strategy to globally enhance the integrity of master data. ",
                "They should use one global controlling area and assign the credit control areas to the controlling area. ",
                "They should define multiple controlling areas and assign company codes to the controlling areas. ",
                "They should use one standard global chart of accounts and one global controlling area and assign the company codes to the controlling area.",
                null,
                "X", "X", null, null, "X", null, Question.C_TFIN22_64);
        addQuestion(a199);

        Question a200 = new Question("Which of the following are the usage scenarios for Solution Manager? (Choose three) ",
                "Implementation",
                "Optimization",
                "Retirement",
                "Operations",
                "Validation",
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a200);

        Question a201 = new Question("A new SAP customer is looking for a lean monthly reporting that should visualize their requirements of: ? Cost of Goods Sold Accounting ? Periodic Profitability Accounting ? Return on Investment (ROI) key figures ? Cost analysis including additional accrued cost Which application meets all of these reporting requirements? ",
                "Profit Center Accounting drilldown reporting",
                "Profitability reporting in account-based CO-PA",
                "Profitability reporting in costing-based CO-PA",
                "Fl balance sheet and profit and loss reporting based on US GAAP",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a201);

        Question a202 = new Question("You are creating an Fl posting in classic GL with assignment to a CO object? ",
                "The posting will only be posted to the original assigned CO object. ",
                "The posting will be assigned to the top node of the profit center standard hierarchy. ",
                "The posting will be assigned to the dummy profit center. ",
                "The posting cannot be saved.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a202);

        Question a203 = new Question("For which purpose can you use the result of a reference and simulation cost estimate? ",
                "To calculate a price for an internal activity ",
                "To calculate a simulated product without a material master ",
                "To update the plan data of a production order ",
                "To update the standard price of a reference material",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a203);

        Question a204 = new Question("A customer wants to prepare and execute a global roll-out. Which type of project within SAP Solution Manager do you recommend to start with? ",
                "Implementation Project ",
                "Maintenance Project",
                "Upgrade Project ",
                "Template Project",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a204);

        Question a205 = new Question("Which of the following statements regarding the SAP NetWeaver platform are correct?(Choose two) ",
                "SAP NetWeaver can power both SAP and non-SAP solutions ",
                "SAP NetWeaver''s predefined IT Scenarios describe the allocation of functionality to either the ABAP or Java stack for execution ",
                "SAP NetWeaver is an application platform that serves as the foundation for integrating solutions on several different levels ",
                "SAP NetWeaver enables process integration through modules such as Business Intelligence and Knowledge Management",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a205);


        Question a206 = new Question("Your customer requires a new Report Painter report that displays both cost information and statistical key figures. How can you implement this requirement? ",
                "Define two separate reports and combine them ",
                "Define two horizontal pages in the report. ",
                "Define two variants for the report. ",
                "Define two sections in the report.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a206);

        Question a207 = new Question("What is the prerequisite for sales order controlling?",
                "The sales order item must have a cost object assigned by a requirement class.",
                "The cost object of the sales order item must be created manually in the sales order. ",
                "A product cost collector must be assigned to the sales order item.",
                "A valuated customer order special stock must be assigned to the sales order item.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a207);

        Question a208 = new Question("A customer wants to allocate the over absorption/under absorption of cost centers source related to receiver. What is the most accurate allocation rule? ",
                "Assessment of fixed portions based on any value field of the market segments. ",
                "Assessment of posted amounts based on any value field of the market segments. ",
                "Assessment of posted amounts based on any derivation rule of characteristics.",
                "Assessment of fixed portions based on statistical key figures of the market segment.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a208);

        Question a209 = new Question("What does the planner profile in cost center accounting determine? ",
                "The available planning layouts. ",
                "The required planning sequence. ",
                "The available planning level. ",
                "The available planning methods (for example, top-down, forecast).",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a209);

        Question a210 = new Question("How does the decoupling scenario for production orders in combination with a product cost collector work? ",
                "All costs are posted to the production order, which settles to the product cost collector. ",
                "Costs are posted to the product cost collector and statistically to the production order. ",
                "Costs are posted to the production order and statistically to the product cost collector. ",
                "Costs are only posted to the product cost collector and not to the production order.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a210);

        Question a211 = new Question("An Automotive customer works with 600,000 material numbers in a multi-level production environment. The whole costing run takes several hours. Now they are simulating the impact of an alternative production setup, which uses the same raw materials and semifinished products. What option would you recommend to significantly shorten the duration of the costing run? ",
                "Use the Schedule Manager to optimize the duration of the Costing Run. ",
                "Use the easy cost planning function for simplified and accelerated costing. ",
                "Assign a suitable transfer control strategy to the relevant costing variant in the IMG ",
                "Define a mixed costing strategy and maintain mixing ratios.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a211);

        Question a212 = new Question("Which of the following fields are required to create a cost center in management accounting (CO)?(Choose two) ",
                "User responsible ",
                "Hierarchy area ",
                "Description",
                "Company code",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a212);

        Question a213 = new Question("What happens when a vendor's invoice is posted? ",
                "The payment is applied to the vendor's account. ",
                "The standard price in the material master is recalculated.",
                "The goods receipts/invoice receipts (GR/IR) account within the general ledger is debited. ",
                "An accounting document is generated that posts directly to the accounts payable account within the general ledger.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a213);

        Question a214 = new Question("What are the prerequisites to calculate overhead costs on an internal order?(Choose two) ",
                "Assign the costing sheet to the costing variant. ",
                "Define an overhead key. ",
                "Define a costing sheet. ",
                "Assign the costing sheet in the order master data.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_64);
        addQuestion(a214);

        Question a215 = new Question("Your customer wants to add certain values from a source document into the account document automatically. You recommend them to use a function module. Which of the following are attributes of function modules?(Choose two) ",
                "Function modules are automatically imported via Support Packages. ",
                "Function modules have to be released by SAP. ",
                "Function modules are reusable subroutines.",
                "Function modules can be called out of ABAP programs.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TFIN22_64);
        addQuestion(a215);

        Question a216 = new Question("A customer asks you to explain the category price variances received on production orders. What could be the reason for price variances?(Choose two) ",
                "The activity types were consumed from different cost centers. ",
                "The master data of the consumed materials is V price indicated. ",
                "The valuation variants of the cost estimate and the production order are different. ",
                "The respective routing has changed.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a216);

        Question a217 = new Question("A customer using account based CO-PA sells material from stock. How is the 'cost of goods sold' transferred and valuated? ",
                "Material costs are taken from the goods issue posting (valuated with cost component structure). ",
                "Material costs are taken from the goods issue posting (valuated according price control). ",
                "Material costs are taken from the billing document (valuated with cost component structure). ",
                "Material costs are taken from the billing document (valuated according price control).",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a217);

        Question a218 = new Question("The SAP List Viewer, commonly known as the ALV, is a powerful tool for displaying data. Among the various ALV types, the ALV Grid Control is used for displaying nonhierarchical table data. Which of the following statements about the ALV Grid Control are correct? ",
                "By default, a column header will be taken from the data element which is used for specifying the type of the column. ",
                "When a report with an ALV Grid Control is executed in background processing, the program will terminate abnormally since controls can-not be addressed in background processing. ",
                "The ALV Grid Control can be integrated into a list, a selection-screen, and a classical screen (dynpro). ",
                "The ALV display is automatically refreshed when the data in the data-base table is changed",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a218);

        Question a219 = new Question("A customer wants to perform cost center planning to reflect different expectations for the future. How can the customer create different plans in parallel? ",
                "Use different versions. ",
                "Use different costing variants. ",
                "Use different planning areas.",
                "Use different valuation areas.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a219);

        Question a220 = new Question("A customer is interested in using the SAP Solution Manager. How do you explain it to them? ",
                "Provides the development and runtime environment for SAP applications and can be used for custom development and integration with other applications and systems ",
                "Facilitates the exchange of information among a company's internal software and systems and those of external parties ",
                "Provides business experts with an infrastructure for realizing and operating planning scenarios or other applications ",
                "Provides integrated support of the life-cycle of a business solution, from the Business Blueprint, through configuration to production operation",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a220);

        Question a221 = new Question("Which of the following mapping types are supported in SAP NetWeaver PI? (Choose three) ",
                "Java",
                "Message Mapping ",
                "XSLT",
                ".NET",
                null,
                null,
                "X", "X", "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a221);

        Question a222 = new Question("What is the main idea of SAP NetWeaver Information Lifecycle Management (ILM)? ",
                "ILM complements data archiving with retention management and retention warehousing. ",
                "ILM replaces data archiving. ",
                "ILM is the new tool to archive SAP NetWeaver Business Warehouse objects. ",
                "ILM is an external storage system delivered by SAP",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a222);

        Question a223 = new Question("What are the key building blocks of the ASAP Roadmap? ",
                "Project Quality Gates and Review Services",
                "Phases and Work streams ",
                "Phases and Deliverable groups",
                "Phases and Activities",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a223);

        Question a224 = new Question("Which of the following are the right organizational assignments starting from the top of the organization structure (top-down)? ",
                "Controlling area, Operating concern, Company code, Plant, Storage location ",
                "Company code, Operating concern, Controlling area, Plant, Storage location ",
                "Operating concern, Controlling area, Company code, Plant, Storage location ",
                "Operating concern, Controlling area, Company code, Storage location, Plant",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a224);

        Question a225 = new Question("Which common usage scenario is missing from the list of usage scenarios below? Implement SAP Solutions, Monitor SAP Solutions, Manage Service Desk, link to SAP services, upgrade SAP solutions. ",
                "Monitor Service Desk ",
                "Manage Change Requests ",
                "Implement SAP services. ",
                "Link to change Requests",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a225);

        Question a226 = new Question("Which of the following needs to be activated in the New GL to implement profit center accounting for all costs and revenues?(Choose two) ",
                "Scenario profit center update",
                "Scenario segment reporting ",
                "Real-time integration CO/FI ",
                "Document splitting",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a226);

        Question a227 = new Question("A customer uses assessment cycles in cost center accounting. What do you need to do to receive the results on the profit centers in New General Ledger Accounting? ",
                "Define and execute the appropriate cycles in New General Ledger Accounting ",
                "Activate plan integration for profit centers ",
                "Activate document split for cost centers in New General Ledger Accounting ",
                "Activate real-time reconciliation between CO and Fl",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a227);

        Question a228 = new Question("A customer uses a discrete manufacturing scenario to produce goods to stock. What is a typical customer requirement for using product cost collectors as cost objects? ",
                "The customer demands to get work in process based on actual.",
                "The customer demands to control many production orders on one cost object. ",
                "The customer demands to see the aggregated plan costs of the production orders on the product cost collector",
                "The customer demands to do a multi-level costing for the used cost objects.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a228);

        Question a229 = new Question("Select the benefits of SAP Solution Manager from the list of items below. (Choose three) ",
                "Integration of SAP Solutions ",
                "Reduced cost of operations ",
                "Separation of SAP solutions",
                "Faster ROI ",
                "Lower ROI",
                null,
                "X", "X", null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a229);

        Question a230 = new Question("Which costing items are valid for a simu-lation costing?(Choose three) ",
                "K - Cost center ",
                "T - Text item ",
                "E - Internal activity ",
                "M - Material ",
                "S - Sales order item",
                null,
                null, "X", "X", "X", null, null, Question.C_TFIN22_64);
        addQuestion(a230);

        Question a231 = new Question("A customer in a high-inflation country produces goods consuming raw materials with high price differences. Which option allows the roll-up of these price differences to the final product? ",
                "Use moving average price for all materials.",
                "Use actual activity price determination in Cost Center Accounting. ",
                "Implement Actual Costing in the Material Ledger.",
                "Implement Transfer pricing in the Material Ledger.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a231);

        Question a232 = new Question("Which of the following SAP Life-Cycle Data Management functions provides the integration of external files into SAP ERP? ",
                "Variant Configuration Management ",
                "Engineering Change Management ",
                "Document Management ",
                "Product Structure Browser",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a232);

        Question a233 = new Question("A customer has a 1000 cost centers each with about 100 different primary cost elements. Select the ranking of cost allocation methods according to the shortest expected runtime (list the fastest method first). ",
                "Periodic Reposting < Assessment < Distribution ",
                "Assessment < Periodic Reposting < Distribution ",
                "Distribution < Assessment < Periodic Reposting",
                null,
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a233);

        Question a234 = new Question("What is a report group in Report Painter required for? ",
                "To add a report as a sub folder in the Easy Access Menu",
                "To run reports in costing based profitability analysis. ",
                "To serve as a template for the creation of new Report Painter reports. ",
                "To assign further reports via the report/report interface.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a234);

        Question a235 = new Question("When do you calculate variances for a production order with order controlling? ",
                "At the end of each period, independent of the order status. ",
                "After the final delivery of the production order. ",
                "After the first partial delivery of the production order. ",
                "After the final confirmation for the last operation",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a235);

        Question a236 = new Question("A customer uses assessment cycles in cost center accounting. How can the customer see the results on the profit centers in New GL? ",
                "By activating plan integration for profit centers. ",
                "By activating the real-time reconciliation between CO and FI. ",
                "By activating document split for cost centers in New GL. ",
                "By defining and execute the equivalent cycles in the New GL.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a236);

        Question a237 = new Question("Which of the following is a typical sequence of steps in a Purchase to Pay process? ",
                "Purchase requisition -> Purchase order -> Goods receipt -> Invoice verification Payment ",
                "Purchase requisition -> Goods issue -> Purchase verification -> Invoice receipts Payment ",
                "Purchase requisition -> Goods verification -> Purchase receipts -> Invoice receipts Payment ",
                "Purchase order -> Purchase requisition -> Goods receipt -> Invoice verification Payment",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a237);

        Question a238 = new Question("What is the correct sequence of the ASAP methodology phases? ",
                "Project Preparation -> Business Blueprint -> Realization -> Training -> Go Live Support > Run ",
                "Project Launch -> Requirements and Design -> Build -> Go Live -> Run -> Optimization ",
                "Project Preparation -> Business Blueprint -> Realization -> Final Preparation -> Go Live Support -> Run ",
                "Plan Project -> Design Solution -> Build Solution -> Test -> Hand Over to IT -> Operate",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TFIN22_64);
        addQuestion(a238);

        Question a239 = new Question("How can you settle different cost elements of an internal order to different receivers?",
                "Use a splitting structure. ",
                "Use a PA transfer structure. ",
                "Use an allocation structure. ",
                "Use a source structure.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TFIN22_64);
        addQuestion(a239);

        Question a241 = new Question("On what does SAP Early Watch Alert report? (Choose two) ",
                "System configuration  ",
                "Business processes  ",
                "Performance trending  ",
                "Hardware failures",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a241);

        Question a242 = new Question("Identify the four main Types of roadmaps reviewed. (Choose four) ",
                "Upgrade Roadmap ",
                "Solution Management Roadmap ",
                "Implementation roadmap ",
                "Solution Roadmap ",
                "Download Roadmap ",
                "Global template roadmap",
                "X", "X", "X", null, null, "X", Question.C_TFIN22_64);
        addQuestion(a242);

        Question a243 = new Question("Which methods allow a customer to assign their plan costs more accurately to the different activity types per cost center?(Choose two) ",
                "Activity-dependent manual cost planning ",
                "Plan cost assessment cycle ",
                "Usage of a splitting structure for the plan price calculation ",
                "Pre-distribution of fixed cost",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TFIN22_64);
        addQuestion(a243);

        Question b1 = new Question("Which of the following task types are supported by the Closing Cockpit or Schedule Manager? (Choose three) ",
                "Spreadsheets",
                "Transactions",
                "Reconciliation keys ",
                "Notes (as a reminder or milestone) ",
                "Programs with or without variant",
                null,
                null,"X",null,"X","X",null,Question.C_TFIN52_66);

        addQuestion(b1);

        Question b2 = new Question("Which of the following accounts are updated directly? ",
                "Accounts in the group chart of accounts",
                "Accounts in the operating chart of accounts ",
                "Accounts in the master chart of accounts ",
                "Accounts in the country chart of accounts",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b2);

        Question b3 = new Question("To which of the following does an asset class apply? ",
                "To all company codes in a controlling area ",
                "To all company codes in an instance (client-independent)",
                "To all company codes in a client ",
                "To all company codes within a client, which share the same chart of accounts",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b3);

        Question b4 = new Question("In your leading ledger (ledger solution), balance sheets must be created for company codes and segments. Which Customizing settings do you need to make? (Choose two) ",
                "Define a retained earnings account. ",
                "Define two retained earnings accounts and assign them to your P&L accounts. ",
                "Assign the Segment Reporting scenario to your leading ledger. ",
                "Activate cost of sales accounting.",
                null,
                null,
                "X",null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b4);

        Question b5 = new Question("What are the prerequisites for setting up cross-company-code cost accounting? (Choose two) ",
                "The same fiscal year variant is used for all company codes. ",
                "The same currency is used for all company codes. ",
                "The same variant for open periods is used for all company codes. ",
                "The same chart of accounts is used for all company codes.",
                null,
                null,
                "X",null,null,"X",null,null,Question.C_TFIN52_66);

        addQuestion(b5);

        Question b6 = new Question("You post a G/L document. For the Text field, the field status of the posting key is set to Required Entry and the field status of the G/L account is set to Hidden Entry? What happens during posting? ",
                "The document is posted.",
                "A warning message is shown. ",
                "An error message is shown. ",
                "The Text field is hidden.",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b6);

        Question b7 = new Question("For reports in Asset Accounting, which object do you have to use and, where necessary, customize to determine the sort level and/or the summation level? ",
                "Depreciation area ",
                "Sort key ",
                "Sort variant ",
                "Valuation area",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b7);

        Question b8 = new Question("Your company currently uses internal number ranges for documents. You are rolling out your system in a new country. It is a legal requirement in this country to have external document numbering on vendor invoices (currently document type KR). You have copied the number ranges from the existing company code to the new company code. Which Customizing settings do you have to make to meet this requirement and have a minimal effect on the existing system configuration? ",
                "Mark a new document number range as external and assign it to the document type KR. ",
                "Create a new external document type and assign the number range 51 to the new document type. ",
                "Create a new document type and a new external number range interval as external. Assign the new number range to the new document type. ",
                "Mark existing number range interval 51 as external for the new company code.",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b8);

        Question b9 = new Question("You have two house banks. Each house bank has three bank accounts. How many separate G/L accounts do you recommend the customer creates in the chart of accounts? ",
                "Six '' one for each combination of house bank and bank account ",
                "One for all postings ",
                "Two '' one for each house bank ",
                "Three '' one for each bank account",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b9);

        Question b10 = new Question("Which line item field is filled automatically by the sort key field of a master record (G/L account, customer, or vendor)? ",
                "Item text ",
                "Assignment",
                "Amount in document currency ",
                "Number of the invoice to which the transaction belongs",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b10);

        Question b11 = new Question("You want to reconcile the amounts you have in a main bank G/L account in your system with the daily bank statement. You create a single intermediate G/L bank account for each bank. All transactions with the bank are posted through the intermediate account. Which of the following indicators do you have to activate in the G/L account characteristics of the intermediate account? (Choose two) ",
                "Reconciliation account for account type Bank ",
                "Line item display ",
                "P&L statement account ",
                "Post automatically only ",
                "Open item management",
                null,
                null,"X",null,null,"X",null,Question.C_TFIN52_66);
        addQuestion(b11);

        Question b12 = new Question("What additional options do parking documents offer compared to holding documents? (Choose two) ",
                "A parked document can be posted cross-client to minimize the total cost of ownership (TCO). ",
                "A parked document can be posted using a workflow. ",
                "A parked document can be changed and posted by another user, thereby supporting the principle of dual control. ",
                "A parked document can be posted via automatic speech recognition.",
                null,
                null,
                null,"X","X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b12);

        Question b13 = new Question("Your customer has two company codes in the same client. Each company code has a different operational chart of accounts. The customer has a country-specific chart of accounts for each company code. How does this influence how you create customer master records?",
                "You have to create customer master records for each credit control area. ",
                "You have to create one master record for each customer. ",
                "You have to create customer master records for each country-specific chart of accounts. ",
                "You have to create customer master records for each chart of accounts.",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b13);

        Question b14 = new Question("What do you define when you configure a dunning procedure? ",
                "Dunning levels and dunning charges for each dunning level ",
                "Dunning levels and account determination to post dunning interest ",
                "Dunning charges for each dunning level and customers to be dunned ",
                "Dunning levels and the language of the dunning note",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b14);

        Question b15 = new Question("Which of the following factors determine the field status for vendors? ",
                "Account group, transaction, and company code ",
                "Transaction, chart of accounts, and company code",
                "Account group, chart of accounts, and company code ",
                "Account group, transaction, and chart of accounts",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b15);

        Question b16 = new Question("You configure the available amounts for bank accounts. What happens to these available amounts during the payment run?",
                "They are set to zero. ",
                "They are updated automatically, but have to be released by another user (dual control). ",
                "They are updated automatically. ",
                "They are not updated.",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b16);

        Question b17 = new Question("A customer wants to create a report that is to be run on a monthly basis showing documents within a specific range for a specific company code that have been posted within the current month. How can you create this type of report?",
                "'' Create a Compact Document Journal report. '' After running the report, save it to your desktop, where it can be updated every month. ",
                "'' Create a Compact Document Journal report. '' Enter the values for the document interval and company code. '' After saving this as a variant, add an appropriate D (Dynamic Date Calculation) variable for the posting date on the Variant Attributes screen. ",
                "'' Create a G/L Account Balances report. '' Enter the values for the document range and company code. '' After saving this as a variant, add an appropriate D (Dynamic Date Calculation) variable for the posting date on the Variant Attributes screen. ",
                "'' Create a Compact Document Journal report. '' Enter the values for the document range and company code. '' After saving this as a variant, add an appropriate T (Table) variable for the posting date on the Variant Attributes screen.",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b17);

        Question b18 = new Question("A customer wants to use document splitting to enable balance sheets by segments. How do you set up the document split? (Choose two) ",
                "Assign the splitting method to the transaction variant. ",
                "Define a non-leading ledger for the split documents.",
                "Assign all document types to business transactions and business transaction variants. ",
                "Define splitting rules.",
                null,
                null,
                null,null,"X","X",null,null,Question.C_TFIN52_66);
        addQuestion(b18);

        Question b19 = new Question("Which object do you have to activate to maintain profit centers directly in Asset Accounting with all business functions for New General Ledger Accounting activated? ",
                "Profit Center Reorganization ",
                "Segment Reorganization ",
                "Profit Center Update Scenario ",
                "Segment Reporting",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b19);

        Question b20 = new Question("When dealing with financial statement versions (FSVs), how do you ensure that the requirements of the various target groups (for example auditors, tax authorities, and banks) are satisfied? ",
                "Create one FSV and enhance it with different sets of notes.",
                "Create one FSV and then save different variants based on the needs of the various groups. ",
                "Create different versions of the same FSV. ",
                "Create different FSVs based on the needs of the target group.",
                null,
                null,
                null,null, null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b20);

        Question b21 = new Question("Down payments can be posted using a special G/L transaction. What is the main benefit of this function? ",
                "It automatically creates the final invoice and clears down payments against it. ",
                "It automatically clears down payment requests.",
                "It posts down payments to a reconciliation account that is different from that of ordinary payables and receivables. ",
                "It shows data in the appendix of the balance sheet.",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b21);

        Question b22 = new Question("Your customer's Accounting department informs you that the company issues checks. They need to easily differentiate payments made by check. How can you facilitate this requirement?",
                "Create an additional field in the coding block called Check. ",
                "Use the payment method for checks. ",
                "Use the payment term for checks. ",
                "Customize a line item report that filters data according to the text field, and instruct users to enter the word \"Check\" in the field when entering such payments.",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b22);

        Question b23 = new Question("Your chief accountant would like to display company-owned cars separately in the balance sheet. These cars were previously included in the asset class \"factory and office equipment\". What do you have to configure? ",
                "Create a new asset class, but use the same account determination. ",
                "Create a new account determination, but no new asset class. ",
                "Create evaluation groups to subdivide all assets of the class. ",
                "Create a new asset class and a new account determination.",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b23);

        Question  b24 = new Question("Which of the following are the main components of a drilldown report? ",
                "Characteristics and key figures",
                "Characteristics and variables ",
                "Variables and general selection criteria ",
                "Variables and key figures",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b24);

        Question b25 = new Question("Your customer wants to access line items for individual P/L accounts without leaving the balance sheet and P/L display. What do you recommend? ",
                "Activate the Line Item Display flag in the financial statement version. ",
                "Use a drilldown report. ",
                "Use the standard Financial Statements (RFBILA00) report. ",
                "Run a line item report.",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b25);

        Question b26 = new Question("You have been asked to showcase the \"asset sale with customer\" scenario in the next blueprint workshop meeting. What do you have to consider when posting an asset sale? (Choose two) ",
                "You must specify the asset value date. ",
                "You must post the sale against an asset that has an acquisition. ",
                "You must use posting key 75 (credit asset) and select the specific asset sale in the account field. ",
                "You must calculate and input the profit or loss from the asset sale in a separate line during posting.",
                null,
                null,
                "X","X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b26);

        Question b27 = new Question("At which level is the vendor account number (master record) assigned? ",
                "At a combination of client and company code segment level",
                "At a combination of client and purchasing organization segment level ",
                "At client level ",
                "At company code segment level",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b27);

        Question b28 = new Question("A customer wants to use segment reporting on balance sheet and P/L accounts. Which business function do you recommend? ",
                "Special Purpose Ledger ",
                "Profitability Analysis ",
                "New General Ledger Accounting ",
                "Profit Center Accounting",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b28);

        Question b29 = new Question("At the end of a fiscal year the system carries forward the balance of certain accounts to a special retained earnings account and sets them to zero. Which accounts are treated in this way?",
                "Balance sheet and P&L accounts ",
                "P&L accounts ",
                "Accounts managed only on the basis of open items ",
                "Balance sheet accounts",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b29);

        Question b30 = new Question("A company uses different terms of payment. What can you define for these terms of payment? (Choose three) ",
                "Cash discount periods ",
                "Interest calculation ",
                "Baseline date for due date calculation",
                "Cash flow calculation ",
                "Cash discount percentage rates",
                null,
                "X",null,"X",null,"X",null,Question.C_TFIN52_66);
        addQuestion(b30);

        Question b31 = new Question("What are the advantages of the Payment Medium Workbench (PMW)? (Choose three) ",
                "It activates the automatic import of settings related to changes in payment transaction laws. ",
                "It provides a uniform set of functions for all kinds of payment methods.",
                "It automatically creates direct debits. ",
                "It can be used to change payment formats without modifying the programs. ",
                "It can be used to create new payment formats.",
                null,
                null,"X",null,"X","X",null,Question.C_TFIN52_66);
        addQuestion(b31);

        Question b32 = new Question("What do you define when you set up a depreciation area? ",
                "The posting to the general ledger ",
                "The company code in Asset Accounting ",
                "The account determination ",
                "The asset number ranges",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b32);

        Question b33 = new Question("What are the benefits of using the accrual engine? (Choose three)",
                "The accrual engine can correct accruals in the previous month even if that period is closed. ",
                "The accrual engine is client-independent. ",
                "The accrual engine calculates the accrual amounts automatically. ",
                "The accrual engine can simulate planned future accruals. ",
                "The accrual engine supports parallel accounting.",
                null,
                null,null,"X","X","X",null,Question.C_TFIN52_66);
        addQuestion(b33);

        Question b34 = new Question("In a payment run, the data entered for a payment method in the document may differ from the master data. How does the system resolve this? ",
                "The payment run temporarily stops, and the system prompts you to correct the data. After you have corrected the data, the payment run continues. ",
                "The payment run stops and the system issues an error message.",
                "Master data overrides document data.",
                "Document data overrides master data.",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b34);

        Question b35 = new Question("Which of the following objects must you enter when posting an asset acquisition against a vendor? (Choose three) ",
                "Document type ",
                "Fixed asset balance sheet account ",
                "Special G/L transaction ",
                "Asset master record ",
                "Transaction type",
                null,
                "X",null,null,"X","X",null,Question.C_TFIN52_66);
        addQuestion(b35);

        Question b36 = new Question("Which of the following is mandatory to make G/L accounts ready for posting? ",
                "A chart of accounts segment and at least one cost element ",
                "A company code segment and at least one cost element",
                "A chart of accounts segment and at least one functional area ",
                "A chart of accounts segment and at least one company code segment",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b36);

        Question b37 = new Question("Your company uses only book depreciation and you activate the new depreciation engine. The book depreciation key Z010 curently used by an asset should be changed to Z020. The asset depreciation started two years ago, and depreciation for the current year has already been posted for the months of January, February, and March (monthly depreciation run). The change should take effect from April 1st. How can you implement this change? (Choose two) ",
                "Undo the depreciation postings for the asset in the current year. Then call the Depreciation Areas screen in the asset master and change the key from Z010 to Z020. ",
                "Call the Depreciation Areas screen in the asset master and assign the key Z020 with validity start date of April 1st.",
                "Call the Depreciation Areas screen in the asset master and change the depreciation key from Z010 to Z020. Also change the ordinary depreciation start date to April 1st. ",
                "Create a new asset referencing the asset you want to change. On the Depreciation Areas screen, select depreciation key Z020. Then post an asset transfer from the existing asset to the new asset.",
                null,
                null,
                null,"X",null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b37);

        Question b38 = new Question("A customer requires a balance sheet per segment but does not require a balance sheet per profit center. You discuss the features of segments and profit centers with him. Which features can you highlight? (Choose three) ",
                "You can assign the segment to the asset master record.",
                "You can assign a segment to a cost accounting object such as a cost center or internal order. ",
                "Segments are derived from profit centers in the standard system. ",
                "You can assign the segment to the material master. ",
                "You can post in FI directly to a segment.",
                null,
                "X",null,"X",null,"X",null,Question.C_TFIN52_66);
        addQuestion(b38);

        Question b39 = new Question("How do you prevent duplicate vendors from being created? (Choose two) ",
                "Activate master data comparison for the vendor.",
                "Activate message control for the duplicate vendor check. ",
                "Run the Vendor De-Duplication report. ",
                "Use matchcode to check whether the vendor already exists.",
                null,
                null,
                null,"X",null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b39);

        Question b40 = new Question("Your customer sells products and services. They have to separate the invoices into invoices for products and invoices for services. Which object do you have to use to create dunning notices dependent on the division (product or service)? ",
                "Separate dunning runs ",
                "Dunning areas",
                "Dunning block reasons ",
                "Dunning keys",
                null,
                null,
                null,"X",null, null,null,null,Question.C_TFIN52_66);
        addQuestion(b40);

        Question b41 = new Question("Which of the following describe characteristics of master data? (Choose two) ",
                "Master data is used on a long-term basis for multiple business processes. ",
                "Master data is typically assigned to organizational levels.",
                "Master data must be assigned on company code level. ",
                "Master data cannot be changed after creation. ",
                "Master data is a template for transactional data.",
                null,
                "X","X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b41);

        Question b42 = new Question("You want to update the Search Term2 field in your customer master data, but the field does not appear in the maintenance transaction. Which field status definitions do you have to check and, if necessary, change in Customizing? (Choose two) ",
                "Field status definitions of activities ",
                "Field status definitions of company codes ",
                "Field status definition of the assigned reconciliation account",
                "Field status definitions of account groups",
                null,
                null,
                "X",null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b42);

        Question b43 = new Question("How does SAP support impairment posting?",
                "By using new transaction codes for retirements ",
                "By using Segment Reporting ",
                "By using worklists",
                "By using special depreciation keys",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b43);

        Question b44 = new Question("In which Customizing activity do you decide which special G/L transactions are to be paid automatically via the payment program? ",
                "Set Up Payment Methods per Company Code for Payment Transactions ",
                "Set Up Paying Company Codes for Payment Transactions ",
                "Set Up All Company Codes for Payment Transactions ",
                "Set Up Payment Methods per Country for Payment Transactions",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b44);

        Question b45 = new Question("You want to capitalize an asset under construction (AuC) using the line item settlement process. However, the settlement does not work. What could be the reasons for this? (Choose three)",
                "There is no settlement profile assigned to the company code.",
                "The AuC has not been released with the status \"Technically Complete\".",
                "The status of the AuC is set to \"Summary Management\". ",
                "The Depreciation Engine is not active.",
                "The settlement profile does not allow assets as valid receivers.",
                null,
                "X",null,"X",null,"X",null,Question.C_TFIN52_66);
        addQuestion(b45);

        Question b46 = new Question("You entered a non-invoice-related credit memo and selected Net Due 30 Days as the term of payment. The Invoice Reference field is empty. What effect does this have on the term of payment entered in the credit memo?",
                "The term of payment entered in the credit memo is ignored during clearing. ",
                "The term of payment entered in the credit memo is replaced by the term of payment from the last valid customer invoice. ",
                "An error occurs. ",
                "The term of payment entered in the credit memo is used during clearing.",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b46);

        Question b47 = new Question("In the Data Entry view, what is the maximum number of line items in a single FI document? ",
                "9999",
                "999 ",
                "Unlimited ",
                "99",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b47);

        Question b48 = new Question("How can the short text field of a G/L account be changed? ",
                "Individually, in the company code segment",
                "By making the change at the start of a new fiscal year ",
                "By making sure that the field status of the chart of accounts segment allows this",
                "Centrally, in the chart of accounts segment",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b48);

        Question b49 = new Question("What are the prerequisites for posting a vendor invoice in Financial Accounting? (Choose two) ",
                "You have maintained the currency exchange rates in the system.",
                "You have set up a number range for the vendor invoice document type. ",
                "You have created a company code segment in the vendor master.",
                "You have updated the bank details section of the vendor.",
                null,
                null,
                null,"X","X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b49);

        Question b50 = new Question("Which functions are provided by the Reclassify Payables/Receivables closing activity? (Choose two) ",
                "Open item analysis for liquidity forecast",
                "Regrouping and sorting of payables and receivables ",
                "Credit check and rating of open items ",
                "Adjustment postings for changed reconciliation accounts",
                null,
                null,
                null,"X",null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b50);

        Question b51 = new Question("How do you implement parallel accounting in Asset Accounting? ",
                "By using two asset classes ",
                "By using an extra chart of accounts ",
                "By using two depreciation areas ",
                "By using two different charts of depreciation",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b51);

        Question b52 = new Question("You set up a new account group. Which Customizing settings for vendors can you control directly in this account group? (Choose two) ",
                "The sensitive fields for dual control ",
                "The One-Time Account checkbox ",
                "The fields that are available during posting to vendor accounts ",
                "The company codes that can be used for the account group",
                "The number range of master data accounts",
                null,
                null,"X",null,null,"X",null,Question.C_TFIN52_66);
        addQuestion(b52);

        Question b53 = new Question("You are testing the payment program. The payment run has been executed. When you look at the program log you notice that the payment method check shows that part of the address is missing from the vendor master. In Customizing for payment programs, where can you see which data is mandatory? ",
                "Paying company codes for payment transactions",
                "Company code data for the payment methods",
                "Country data for the payment methods ",
                "Bank account determination",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b53);

        Question b54 = new Question("Which factors determine the fiscal year variant you would assign to a company code? (Choose two) ",
                "The need to control which periods are open for posting for specific user groups",
                "The existence of a shortened fiscal year ",
                "The fiscal year start and end period of the company",
                "The use of a specific fiscal year variant by other company codes on the client ",
                "The need to control which periods are open for posting for the company code",
                null,
                null,"X","X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b54);

        Question b55 = new Question("The head of accounts receivable requires that all items posted to individual customer accounts are posted to their headquarters. Which function do you have to use to fulfill this requirement? ",
                "Head office and branch account",
                "Single bank account",
                "Alternative payer/payee ",
                "Cash management group",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b55);

        Question b56 = new Question("What does the posting key control? (Choose three) ",
                "Debit/credit indicator ",
                "Account type ",
                "Number range ",
                "Field status (of posting key) ",
                "Document type",
                null,
                "X","X",null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b56);

        Question b57 = new Question("The field status definitions from the account group and the transaction are considered for each field. The field status definition with the higher priority is used. Which priority sequence, going from the highest to the lowest, is correct? ",
                "Optional Entry, Hide, Display, Required Entry",
                "Hide, Display, Required Entry, Optional Entry ",
                "Required Entry, Optional Entry, Hide, Display ",
                "Display, Required Entry, Optional Entry, Hide",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b57);

        Question b58 = new Question("What are the call-up points for validations in FI? ",
                "Document header, line item, and complete document",
                "Basic data section, line item, and complete document ",
                "Basic data section, detailed data section, and line item ",
                "Document header, document type, and complete document",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b58);

        Question b59 = new Question("Your customer runs an SAP system with New General Ledger Accounting activated. They want to run a valuation of accounts receivable that are posted in foreign currency. What do you have to do?",
                "Set up a new exchange rate type and assign it to a valuation method. ",
                "Assign a valuation method to all customer master records that you want to valuate. ",
                "Set up a valuation method and assign it to a valuation area.",
                "Set up the Valuation Cockpit to perform this task.",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b59);

        Question b60 = new Question("You entered a G/L account posting and received an error message saying that account type D (customer) is not allowed. Which object causes this error? ",
                "Currency key",
                "Tolerance group ",
                "Document type ",
                "Field status variant",
                null,
                null,
                null,null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b60);

        Question b61 = new Question("Which interactive function is provided by the SAP List Viewer? ",
                "Creation of subtotals for specific values ",
                "Creation of worklists ",
                "Use of the report-report interface ",
                "Mass reversal",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b61);

        Question b62 = new Question("Special G/L transactions can be divided into which types? (Choose three) ",
                "Document parking ",
                "Interest ",
                "Free offsetting entry ",
                "Automatic offsetting entry ",
                "Noted item",
                null,
                null,null,"X","X","X",null,Question.C_TFIN52_66);
        addQuestion(b62);

        Question b63 = new Question("On which level do you define depreciation keys? ",
                "Company code ",
                "Chart of accounts ",
                "Asset class ",
                "Chart of depreciation",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b63);

        Question b64 = new Question("What does the year-end closing program do in Asset Accounting? (Choose two) ",
                "It opens new annual value fields for each asset. ",
                "It checks whether depreciation and assets are fully posted. ",
                "It checks whether the previous year has been closed in Financial Accounting. ",
                "It checks whether assets contain errors or are incomplete.",
                null,
                null,
                null,"X",null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b64);

        Question b65 = new Question("Which activity has an impact on the net book value of an asset? ",
                "Changing the account determination",
                "Changing the useful life of the asset ",
                "Changing the assigned cost center ",
                "Changing the assigned WBS element",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b65);

        Question b66 = new Question("Which transactions in the procurement process with valuated goods receipt create documents in FI? (Choose two) ",
                "Create purchase requisition ",
                "Create purchase order",
                "Post valuated goods receipt ",
                "Enter invoice receipt",
                null,
                null,
                null,null,"X","X",null,null,Question.C_TFIN52_66);
        addQuestion(b66);

        Question b67 = new Question("What options do you have for posting an asset acquisition? (Choose three) ",
                "Asset acquisition integrated with accounts payable ",
                "Asset acquisition using a clearing account",
                "Asset acquisition posted via the payment program ",
                "Asset acquisition posted via the accrual engine ",
                "Asset acquisition posted from Materials Management",
                null,
                "X","X",null,null,"X",null,Question.C_TFIN52_66);
        addQuestion(b67);

        Question b68 = new Question("Your customer wants to clear minor payment differences for incoming payments automatically. Which objects do you have to use to fulfill this requirement? ",
                "Tolerance groups for employees and tolerance groups for document types ",
                "Tolerance groups for employees and tolerance groups for customers/vendors",
                "Tolerance groups for G/L accounts and tolerance groups for employees ",
                "Tolerance groups for G/L accounts and tolerance groups for customers/vendors",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b68);

        Question b69 = new Question("Which elements of a customer account are created when you maintain the account decentralized in Financial Accounting? ",
                "General data, company code data, and purchasing organization data ",
                "General data and company code data ",
                "General data, company code data, and sales area data ",
                "General data and sales area data",
                null,
                null,
                null,"X",null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b69);

        Question b70 = new Question("Which of the following activities generates an FI document if real-time integration between CO and FI has been set up? (Choose two)",
                "A test run for the settlement run of an asset under construction to a G/L account",
                "A subsequent change of a segment in a CO document ",
                "An assessment between cost centers in one company code with different functional areas ",
                "An assessment between cost centers that belong to two different company codes",
                "A distribution between cost centers that reside in two different controlling areas",
                null,
                null,null,"X","X",null,null,Question.C_TFIN52_66);
        addQuestion(b70);

        Question b71 = new Question("Which of the following status symbols are used in customer and vendor line item lists? (Choose three) ",
                "Parked",
                "Cleared",
                "Overdue",
                "Open",
                "Not due",
                null,
                "X","X",null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b71);

        Question b72 = new Question("Which characteristics of account determination can be used to assign realized exchange rate differences to different G/L accounts? (Choose three) ",
                "Chart of accounts ",
                "Reconciliation account ",
                "Currency",
                "Valuation method ",
                "Valuation key",
                null,
                "X","X","X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b72);

        Question b73 = new Question("If a vendor is also a customer, which settings are necessary to clear both roles against each other? (Choose two)",
                "The payment program must be set up to allow debit checks for vendors and credit checks for customers. ",
                "The Clearing with Vendor field must be selected in the customer account, and the corresponding field must be selected in the vendor account. ",
                "The vendor and the customer must be assigned to the same group account. ",
                "The vendor number must be entered in the customer account, or the customer number must be entered in the vendor account.",
                null,
                null,
                null,"X",null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b73);

        Question b74 = new Question("A multinational enterprise acquires a company in a country which has local reporting requirements. The multinational enterprise wants to use one operational chart of account for all companies. How can you fulfill this country-specific requirement? ",
                "Create a country-specific chart of accounts and assign it to the group chart of accounts. ",
                "Create a group chart of accounts and assign it to the company code. ",
                "Create a country-specific chart of accounts and assign it to the regular chart of accounts. ",
                "Create a country-specific chart of accounts and assign it to the company code.",
                null,
                null,
                null,null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b74);

        Question b75 = new Question("Which steps are necessary to run a payment program? (Choose three) ",
                "Schedule print ",
                "Start transfer of open items to the payment program ",
                "Configure open item list ",
                "Maintain parameters ",
                "Start proposal run or payment run",
                null,
                "X",null,null,"X","X",null,Question.C_TFIN52_66);
        addQuestion(b75);

        Question b76 = new Question("Which function can you use to generate inter-company posting documents? (Choose two) ",
                "Intercompany asset transfer ",
                "Central currency valuation ",
                "Central payment",
                "Intercompany dunning",
                null,
                null,
                "X",null,"X",null,null,null,Question.C_TFIN52_66);
        addQuestion(b76);

        Question b77 = new Question("You receive a payment where the difference from the posted invoice is larger than the stated tolerance limit. How can you deal with this? (Choose two) ",
                "Split the received payment so that it falls below the tolerance limit. ",
                "Increase the tolerance limit manually while posting the document.",
                "Post the difference to an account assigned to a reason code. ",
                "Post the difference as a residual item.",
                null,
                null,
                null,null,"X","X",null,null,Question.C_TFIN52_66);
        addQuestion(b77);

        Question b78 = new Question("Your customer is running an SAP ERP system with New General Ledger Accounting activated. All scenarios, but no customer fields, are assigned to the leading ledger. Which objects in the totals table (FAGLFLEXT) can be evaluated with drilldown reports? ",
                "Segments, profit centers, cost centers, business areas, functional areas ",
                "Profit centers, cost centers, business areas, functional areas, divisions ",
                "Business areas, functional areas, segments, profit centers, user IDs",
                "Cost centers, business areas, functional areas, segments, tax codes",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b78);

        Question b79 = new Question("Your customer wants to use the Closing Cockpit for period end closing. What major benefits of the Closing Cockpit do you highlight? (Choose two) ",
                "It enables the use of a task list covering all closing activities. ",
                "It optimizes legacy data transfer.",
                "It closes the posting period automatically on the last day of the period. ",
                "It provides complete documentation of the activities performed during period-end closing.",
                null,
                null,
                "X",null,null,"X",null,null,Question.C_TFIN52_66);
        addQuestion(b79);

        Question b80 = new Question("You want to use external number assignment for specific document types. What is the special feature of external number assignment? ",
                "The numbers can be alphanumeric. ",
                "The number ranges can be used across all company codes. ",
                "The system issues the numbers automatically. ",
                "The number ranges can overlap.",
                null,
                null,
                "X",null,null,null,null,null,Question.C_TFIN52_66);
        addQuestion(b80);

        Question c1 = new Question("The availability check (ATP) is carried out based on which of the following dates?",
                "The material availability date ",
                "The transportation planning date ",
                "The goods issue date ",
                "The loading date ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c1);

        Question c2 = new Question("In the system, it is possible to have zero stock available and still receive a confirmed schedule line in the sales order. Which of the following states the reason for this confirmation?",
                "Stock will be taken from another delivery at the shipping point. ",
                "The system automatically searches other plants for inventory and transfers this inventory to the plant with zero inventory in the sales order. ",
                "The availability check that was carried out included a replenishment lead time in the scope of check. ",
                "A stock transfer will be created by inventory management when you save the sales order. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c2);

        Question c3 = new Question("During sales order processing, a user will be alerted when stock is not available for material entered in the sales order if the availability check was carried out. In which of the following ways will the user be alerted about this situation? ",
                "An error message will appear on the status bar alerting the user to the situation. ",
                "The schedule line will be marked and highlighted by the system.  ",
                "The availability control screen will be displayed.  ",
                "The incompletion log will display the unconfirmed schedule line as a missing field. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c3);

        Question c4 = new Question("Which of the following elements can directly influence whether an availability check will be performed? Note: There are 3 correct answers to this question. ",
                "The schedule line category in the sales document ",
                "The item category in the delivery document ",
                "The check group in the material master",
                "The item category in the sales document ",
                "The sales document type ",
                null,
                "X", "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c4);

        Question c5 = new Question("Which of the following statements regarding material determination are correct? Note: There are 2 correct answers to this question. ",
                "Condition tables must be defined in Customizing (IMG). ",
                "The definition of the substitution reason determines whether a manual or an automatic substitution process should be used. ",
                "The material determination procedure is assigned to a combination of sales areas, customer pricing procedures, and document pricing procedures. ",
                "The relevant substitution reason is specified in the access sequence.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c5);

        Question c6 = new Question("Which of the following statements regarding the free goods process is correct? ",
                "Free goods with exclusive bonus quantity will always create a subitem. ",
                "Free goods with inclusive bonus quantity will always take place without a subitem being generated. ",
                "The free goods calculation rule only allows for whole unit free goods bonus increments. ",
                "Free goods with exclusive bonus quantity must contain the same material for the ordered goods and the free goods.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c6);

        Question c7 = new Question("You want to restrict what materials a customer can order. What do you use to achieve this? ",
                "Material group ",
                "Assortment module",
                "Material listing ",
                "Product hierarchy ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c7);

        Question c8 = new Question("The entry for the assignment of the incompleteness procedures to the sales document types contains the following information: Sales Type: OR Description: Standard Order Procedure: 11 Description: Sales Order Field: IC-dialog is flagged. Which of the following conclusions can you draw from this entry? ",
                "Incomplete standard orders must be released in a dialog for further process steps. ",
                "Procedure 11 specifies which fields in standard orders (header data) are checked for completeness and order type OR cannot be saved if any of the fields are incomplete.  ",
                "Incomplete standard orders can be saved after a warning message (dialog) appears. ",
                "Incomplete standard orders can be saved.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c8);

        Question c9 = new Question("Which of the following SAP NetWeaver components realizes cross-system application processes? ",
                "SAP Exchange Infrastructure (SAP XI) / SAP Process Integration (SAP PI) ",
                "SAP Master Data Management (SAP MDM) ",
                "SAP Enterprise Portal (SAP EP) ",
                "SAP Business Warehouse (SAP BW) ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c9);

        Question c10 = new Question("Which of the following SAP NetWeaver components ensures company-wide unification of data and information in heterogeneous IT environments?",
                "Business Warehouse ",
                "Knowledge Management ",
                "Enterprise Portal",
                "Master Data Management ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c10);

        Question c11 = new Question("Which of the following Service Desk features provides all the functions to analyze and monitor an entire SAP solution centrally?",
                "root cause analysis ",
                "Implementation Roadmap",
                "SAP Notes ",
                "SAP Solution Manager diagnostics ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c11);

        Question c12 = new Question("Which of the following is controlled by the configuration of the billing type? ",
                "How account determination should take place. ",
                "How the item category within the billing document will be determined. ",
                "If a billing plan will be determined when using this billing type. ",
                "If order related billing is supported when using this billing type.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c12);

        Question c13 = new Question("Which of the following data elements represent standard split criteria in billing creation? Note: There are 3 correct answers to this question. ",
                "Material group ",
                "Billing date ",
                "Terms of payment ",
                "Payer",
                "Order reason ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c13);

        Question c14 = new Question("Which of the following statements regarding the processing of the billing due list are correct? Note: There are 3 correct answers to this question. ",
                "The billing due list is used to process sales orders and deliveries that are due for billing. ",
                "The billing due list is used for the periodic creation of billing documents. ",
                "You can only use the billing due list to process documents due for billing on the same date. ",
                "Only the general billing interface can be used for processing the billing due list. ",
                "There are various selection criteria available for processing the billing due list, such as sold-to party, sales organization and shipping point. ",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM62_64);
        addQuestion(c14);

        Question c15 = new Question("A customer is to be billed on the last day of the month, regardless of which day of the month the order and delivery are processed. Which of the following procedures will fulfill this requirement? ",
                "Maintaining a customer-specific billing due list variant and scheduling a periodic job. ",
                "Maintaining a factory calendar with a single date per month and assigning it to the customer master record of the payer. ",
                "Maintaining a billing date profile and assigning it to the sales document type. ",
                "Using the condition technique, assigning a billing date determination profile to the customer master record of the payer. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c15);

        Question c16 = new Question("Which of the following statements regarding the cancellation of billing documents are correct? Note: There are 2 correct answers to this question. ",
                "Billing documents created in a collective billing run cannot be reversed. ",
                "When saving the cancellation document, the corresponding posting is automatically executed in Financial Accounting. ",
                "The cancellation of a billing document leads to resetting the billing status of the originally billed delivery or sales order.",
                "When creating the cancellation document, it is possible to change the pricing conditions. ",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c16);

        Question c17 = new Question("Which of the following statements regarding delivery-related billing are correct? Note: There are 3 correct answers to this question. ",
                "The delivery-related billing relevance is set within the item category. ",
                "A delivery-related billing process can be configured to allow billing without having completed post goods issue.  ",
                "In delivery-related billing, the billing type is proposed based on the configuration of the sales document type used. ",
                "Within the sales order item, it is possible to change the billing relevance from order-related to deliveryrelated. ",
                "The delivery-related billing relevance is set within the sales document type. ",
                null,
                "X", "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c17);

        Question c18 = new Question("Your customers submit payment for open accounts receivables by referring to the sales order document number not the invoice number. Therefore, you maintain customization so that the sales document number is transferred as the reference number in the FI accounting document. Which of the following should you consider when transferring the sales order document number as a reference number to Financial Accounting (FI)? ",
                "Using the sales order number as the reference number will lead to a posting block. Billing documents will have to be released for transfer to FI. ",
                "Only order-related billing will be allowed when using the sales order number as a reference number for FI. ",
                "Using the sales order number as a reference number could lead to an invoice split. ",
                "The sales revenues will be posted to a different account in FI when using the sales order number as the reference number. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c18);

        Question c19 = new Question("After saving the billing document, the subsequent message appears in the status bar: Document 90036111 saved (no accounting document generated). Which of the following are possible reasons for no accounting document being created? Note: There are 2 correct answers to this question. ",
                "In the billing type used, there is a configured posting block. Therefore, the blocked billing document has to be released. ",
                "The account determination cannot determine an account, or determines an account that cannot be posted to automatically. ",
                "The reference number and assignment number differ and therefore accounting documents cannot be generated. ",
                "A posting block was set for the billing document type. This prevents the creation of the FI accounting documents. However, controlling documents were generated. ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c19);

        Question c20 = new Question("In addition to the external balance sheet, you want to create an internal balance sheet according to further criteria - in particular relating to divisions. Which of the following approaches fulfills this requirement?",
                "Creating business areas and direct assignment to company codes",
                "Creating business areas and assignment rules for the business area determination ",
                "Creating business areas and usage of condition techniques for determination logic",
                "Creating an additional company code that is flagged as relevant for the internal balance sheet ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c20);

        Question c21 = new Question("Your finance team wants sales revenues for customers of affiliated companies to be posted to a different sales revenue account on the General Ledger. Which of the following steps are required to allow this? Note: There are 3 correct answers to this question. ",
                "Create an account condition master record for the customers of affiliated companies. ",
                "Assign the affected sales revenue account to the key combination in Customizing that includes the account assignment group field. ",
                "Assign the same predefined account assignment group to the customer master of all customers of affiliated companies. ",
                "Assign an access that includes the account assignment group as a key field within the access sequence used for account determination. ",
                "Maintain the requested sales revenue account directly in the customer master record of the payer. ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c21);

        Question c22 = new Question("You have a rental contract with your customer and you want to invoice them an agreed amount each month for the rental item. How do you set up the system so that the item gets invoiced periodically by the collective billing run? Note: There are 2 correct answers to this question. ",
                "Setting up date proposal maintenance in Customizing with the desired percentages of the amount to be invoiced periodically. ",
                "Assigning an invoicing date calendar in the sales area data of the customer master. ",
                "Maintaining a billing plan type for periodic billing. ",
                "Assigning a billing plan type for periodic billing to the item category of the rental contract item.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c22);

        Question c23 = new Question("Which of the following statements regarding transaction variants are correct? Note: There are 3 correct answers to this question. ",
                "A transaction variant can input default values into data fields ",
                "A transaction variant can have only one screen variant assigned to it. ",
                "A transaction variant allows you to hide fields on a sales order type. ",
                "A transaction variant can have a GuiXT variant assigned to it.",
                "A transaction variant can add new external fields into the sales document. ",
                null,
                "X", null, "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c23);

        Question c24 = new Question("Which of the following statements regarding the customer master account group are correct? Note: There are 3 correct answers to this question. ",
                "Account group configuration allows you to hide fields in the account group.",
                "Account group configuration allows you to assign a text determination procedure to the account group. ",
                "Account group configuration allows you to add new fields to the account group.",
                "Account group configuration allows for two number ranges per account group. ",
                "Account group configuration allows you assign a partner determination procedure to the account group. ",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM62_64);
        addQuestion(c24);

        Question c25 = new Question("Which of the following statements relating to output processing are correct? Note: There are 2 correct answers to this question.  ",
                "If you want to include new document fields in an output, you must enhance the processing routines assigned to the output type. ",
                "The access sequence of the output determination procedure defines which document data will be presented on the output presentation. ",
                "Each output type can have only one transmission medium assigned. ",
                "The allowable transmission mediums are assigned to the condition type in Customizing. ",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c25);

        Question c26 = new Question("Which of the following parts of the text determination procedure is responsible for copying text from a source text object into another text type in another document? ",
                "The access sequence ",
                "The text determination procedure ",
                "The condition table ",
                "The text type ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c26);

        Question c27 = new Question("Which of the following statements about the customer master data are correct? Note: There are 2 correct answers to this question. ",
                "The customer master data is transferred to the sales order and cannot be changed there. ",
                "Address changes in the customer master affect existing documents in the system. ",
                "The customer master is subdivided into general data, company code data, sales area data, and plant data. ",
                "The customer master is created using an account group. ",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c27);

        Question c28 = new Question("In a sales order, which of the following information is derived from the sold-to party customer master? Note: There are 2 correct answers to this question. ",
                "The shipping conditions ",
                "The Incoterms ",
                "The invoice address",
                "The payment terms ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c28);

        Question c29 = new Question("Which of the following criteria influence picking location determination? Note: There are 3 correct answers to this question. ",
                "The Shipping Point ",
                "The customer material number ",
                "The route ",
                "Storage Conditions ",
                "The plant ",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM62_64);
        addQuestion(c29);

        Question c30 = new Question("In which of the following master records can partial delivery agreements be stored? Note: There are 2 correct answers to this question. ",
                "Customer material info record ",
                "In the material master record ",
                "In the customer master record ",
                "Condition master record ",
                "Work center master record ",
                null,
                "X", null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c30);

        Question c31 = new Question("Which of the following statements regarding the material master data are correct? Note: There are 2 correct answers to this question. ",
                "If a delivering plant is defined in the sales data of the material master, this is transferred to a corresponding sales document item and can no longer be changed. ",
                "The sales views of the material master data can be maintained for various sales organization and distribution channel combinations. ",
                "The control tool for the material master is the material type. It needs to be selected whenever you create a new material master record. ",
                "The following information in a sales order is derived from the material master: the material group, the weight, the item category. ",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c31);

        Question c32 = new Question("Which of the following statements relating to delivery and transportation scheduling are correct? Note: There are 2 correct answers to this question. ",
                "The delivery and transportation dates determined in the order are visible at header level. ",
                "The transportation lead time, pick/pack time, loading time and transit time are taken into account for delivery and transportation scheduling. ",
                "When the requested delivery date cannot be confirmed by the backward scheduling, the order can still be saved. ",
                "On the calculated post goods issue date, the material requirements of the item are transferred to the material requirement planning.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c32);

        Question c33 = new Question("In sales documents, the delivery and transportation activities can be scheduled automatically. Analyze the results of the scheduling provided in the following delivery and transportation dates example: Delivery date: June 8, 2010 Goods issue date: June 7, 2010 Loading date: June 4, 2010 Material availability date: June 3, 2010. Which of the following pieces information can you determine from the scheduling results? ",
                "June 8, 2010 is the requirement date transferred to the material requirement planning. ",
                "On June 3, 2010, the delivery document will show on the delivery due list. ",
                "A loading time of 1 day can be expected. ",
                "The availability check is performed for June 7, 2010. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c33);

        Question c34 = new Question("In which of the following situations is forward scheduling performed at the item level during order entry? Note: There are 2 correct answers to this question. ",
                "When the available quantity of the material is not sufficient to meet the material availability date determined by the backward scheduling. ",
                "If the system could not determine a replenishment lead time from the material master. ",
                "When the transportation planning or material availability date determined by the backward scheduling is in the past. ",
                "When the loading date determined by the backward scheduling falls on a public holiday. ",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c34);

        Question c35 = new Question("Which of the following elements directly determines the loading time found in the delivery and transportation schedule of the schedule line in the sales order?  ",
                "The packing material ",
                "The weight ",
                "The loading group ",
                "The shipping point ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c35);

        Question c36 = new Question("Which of the following criteria influence the shipping point determination in the sales document? Note: There are 3 correct answers to this question. ",
                "Loading group ",
                "Plant ",
                "Shipping condition ",
                "Division",
                "Storage condition ",
                null,
                "X", "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c36);

        Question c37 = new Question("Which of the following statements relating to the function of distribution channels is correct? ",
                "The maintenance of distribution channels is optional and is not necessary for single-level enterprise structures. ",
                "The distribution channel can be used to distinguish material master data used during sales order processing. ",
                "A distribution channel has its own address. ",
                "Each shipping point requires its own distribution channel. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c37);

        Question c38 = new Question("The assignment of sales organizations to company codes builds integration between SD and FI. Which of the following statements relating to the assignment of sales organizations to company codes are correct? Note: There are 3 correct answers to this question. ",
                "Each sales organization is assigned to just one company code. ",
                "Sales organizations are assigned to company codes indirectly using the sales area. ",
                "mattext665",
                "Sales organizations are assigned directly to company codes. ",
                "Several sales organizations can be assigned to one company code.  ",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM62_64);
        addQuestion(c38);

        Question c39 = new Question("Which of the following statements relating to the organizational assignment of plants are correct? Note: There are 3 correct answers to this question. ",
                "A plant can be assigned to multiple company codes. ",
                "Several plants can be assigned to one company code. ",
                "Each plant can be assigned to just one company code. ",
                "A plant must be assigned to at least one combination of sales organization and distribution channel to be used as a delivering plant. ",
                "Delivering plants must be assigned to the same company code as the sales organization. ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c39);

        Question c40 = new Question("A sales area consists of which of the following organizational units?",
                "Sales office, distribution channel, and division. ",
                "Sales organization, shipping point, and plant. ",
                "Sales organization, distribution channel, and division. ",
                "Sales organization, distribution channel, and plant. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c40);

        Question c41 = new Question("Which of the following statements regarding outline agreement processes are correct? Note: There are 3 correct answers to this question. ",
                "A scheduling agreement contains fixed delivery dates and quantities. ",
                "A value contract defines that your customer agrees to purchase a fixed total value (target amount) of goods and services during the defined period. ",
                "A value contract defines that your customer agrees to purchase a fixed quantity of goods and services during the defined period. ",
                "A quantity contract contains fixed delivery dates and quantities. ",
                "When creating sales documents, the system can check if open contracts exist for the respective customer. ",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM62_64);
        addQuestion(c41);

        Question c42 = new Question("Which of the following statements regarding quantity contracts is correct?  ",
                "Quantity contract items will show up in the delivery due list when ready for delivery. ",
                "Quantity contracts are delivered using a contract release order. ",
                "Different requested delivery dates are maintained in the schedule lines of the quantity contract. ",
                "Quantity contracts contain details about the customer's requested delivery dates. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c42);

        Question c43 = new Question("Which of the following settings in Customizing do you have to maintain for a scheduling agreement? ",
                "A schedule line category ",
                "A product hierarchy ",
                "A billing plan ",
                "The copying control for the release order ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c43);

        Question c44 = new Question("Which of the following elements are necessary to determine the pricing procedure in a sales document? Note: There are 3 correct answers to this question. ",
                "Condition master data ",
                "The document pricing procedure of the sales document type ",
                "Sales area ",
                "The customer pricing procedure from the customer master ",
                "Terms of payment ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c44);

        Question c45 = new Question("Which of the following statements relating to condition records are correct? Note: There are 3 correct answers to this question. ",
                "The scale basis can be structured based on value or quantity among others. ",
                "Changing a determined condition within the sales order leads to an update of the respective condition record master data. ",
                "Condition records can be maintained for all condition types that have assigned an access sequence. ",
                "The number of scale levels within condition records is limited to a maximum of five. ",
                "A lower and upper limit can be defined for each condition record. ",
                null,
                "X", null, "X", null, "X", null, Question.C_TSCM62_64);
        addQuestion(c45);

        Question c46 = new Question("Which of the following functions can be used to display an overview of customer-specific prices for various customers on one screen? ",
                "Pricing procedure ",
                "Pricing report ",
                "Pricing log ",
                "Net price list ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c46);

        Question c47 = new Question("In the future, your sales representatives should be able to maintain freight costs as condition records based on the sales organization, distribution channel, incoterms (part 1), and destination country. Up to now, this level of maintenance is not supported at all in your system. Which of the following objects in customizing needs to be maintained to allow this feature in condition maintenance? ",
                "Pricing procedure ",
                "Access sequence ",
                "Condition type ",
                "Condition table ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c47);

        Question c48 = new Question("You have maintained condition records for a sales promotion discount (ZA00) for customer T-L67A01 who has been assigned to price group 02 (occasional buyer). If multiple discounts are found for ZA00, only the best condition should be active. In which of the following ways do you implement this business requirement? ",
                "Maintain the best condition indicator within both condition records and assign the exclusive flag to the condition type itself. ",
                "Maintain the exclusive indicator for the sales promotion discount (ZA00) within the pricing procedure and implement the respective condition exclusion. ",
                "Delete the exclusive condition access indicator in the access sequence used for the sales promotion discount (ZA00), then create and assign the respective condition exclusion procedure. ",
                "Assign a condition exclusion group to the condition type and use the respective requirement within the pricing procedure to check this setting. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c48);

        Question c49 = new Question("In which of the following ways do the condition type and condition records of rebate agreements vary in comparison to condition types and records of standard discounts? Note: There are 2 correct answers to this question. ",
                "Possibility to maintain scales ",
                "Usage of different calculation types",
                "Usage of a different condition class ",
                "Possibility to maintain accrual rates within condition records ",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c49);

        Question c50 = new Question("In your project, you have already set up the condition type K029 as a gross weight calculated discount based on the material group. Additionally, you want to implement that for ordered materials which belong to the same material group. The system should accumulate the gross weight of the items for determining the scale rate. For the required weight accumulation, which of the following functions should be used for condition type K029? ",
                "Structure condition ",
                "Condition supplements ",
                "Group condition ",
                "Scale basis ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c50);

        Question c51 = new Question("Your sales representative wants to enter a discount that should only be entered manually within the pricing screen of a sales order in addition to the conditions that were automatically determined. In which of the following ways do you implement this business requirement? Note: There are 2 correct answers to this question. ",
                "Ensure that the condition type exists in the pricing procedure used in the sales order. ",
                "Mark the condition type within the pricing procedure as a manual condition. ",
                "Assign an access sequence to the condition type. ",
                "Maintain a condition record for the discount that should be entered manually. ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c51);

        Question c52 = new Question("You have been asked to change a process so that during sales invoicing, any manually changed pricing elements in the pricing procedure of the sales document are copied from the sales order to the billing document unchanged, but the other automatically determined conditions are redetermined. In which of the following places is this controlled? ",
                "In the billing type ",
                "In the item category of sales order item ",
                "In copy control at item level ",
                "In the condition type ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c52);

        Question c53 = new Question("You are using customer hierarchies. The discount HI01 should be based on the values maintained on the different nodes of a customer hierarchy. Which of the following possibilities allow you to integrate this discount into your pricing strategy? Note: There are 2 correct answers to this question. ",
                "Assigning an access sequence to the condition type HI01 consisting of multiple accesses using the same condition table. During each access, a different node is filled as the document field into the source field HIENR. ",
                "Implementing a pricing procedure that contains the condition type HI01 several times according to the number of levels of your customer hierarchy. In addition, setting a priority within the pricing procedure ",
                "Setting condition type HI01 as a structure condition. Based on this condition, records for the different hierarchy nodes can be maintained and will be found automatically.",
                "Assigning an access sequence to the condition type HI01 consisting of one access using a condition table that contains all relevant nodes. In addition, fixed key fields and free fields as well as priorities have to be defined. ",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c53);

        Question c54 = new Question("In which of the following can the delivery relevance of a product be controlled?  ",
                "In the delivery type. ",
                "In the material master data. ",
                "In the schedule line category. ",
                "In the sales document type. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c54);

        Question c55 = new Question("In which of the following circumstances can functions be controlled by the item category? Note: There are 3 correct answers to this question.  ",
                "If an item is relevant for billing.",
                "If the availability check is performed. ",
                "If schedule line items are allowed. ",
                "If an item is relevant for rejection and a reason for rejection is assigned to it.  ",
                "If an item is relevant for pricing. ",
                null,
                "X", null, "X", null, "X", null, Question.C_TSCM62_64);
        addQuestion(c55);

        Question c56 = new Question("Which of the following document flows describes a possible standard sales process?",
                "Inquiry - Delivery - Transfer order - Post goods issue - Invoice - Accounting document ",
                "Standard order with reference to an inquiry - Delivery - Transfer order - Post goods issue - Invoice - Accounting document ",
                "Quotation - Delivery - Transfer order - Post goods issue - Invoice - Accounting document ",
                "Release order with reference to a previous delivery - Delivery - Transfer order - Post goods issue - Invoice - Accounting document ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c56);

        Question c57 = new Question("In which of the following ways can you use the document flow?",
                "You can navigate directly to individual documents in change mode. ",
                "You can change any existing target documents without affecting the status in the source document. ",
                "You can review how documents and items of a sales process are linked.  ",
                "You can reset the status of any document in order to redo the entire process. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c57);

        Question c58 = new Question("Which of the following statements regarding copy control is correct? ",
                "The item category of the target document must always be specified in the copy control. ",
                "If the copy control table contains only a source document, the target is determined automatically (hard coded by SAP) based on the document flow of the sales process. ",
                "Copy control allows you to create sales documents with reference to sales documents, delivery documents, and billing documents. ",
                "Copy control for sales documents controls header, item, and schedule line level data transfer. ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c58);

        Question c59 = new Question("Which of the following statements regarding the bills of material (BOM) in the sales order are correct? Note: There are 2 correct answers to this question. ",
                "The sales document type controls whether bills of material relevant to sales are to be exploded in the sales document or not. ",
                "Bills of material are exploded in the sales document as a structure from the main item and sub-item based on the item category. ",
                "Bills of material are defined as master data. The bill of material can be flagged as BOM using sales and distribution. ",
                "The depth of the explosion of bills of material in the sales document is controlled by specifying the explosion level in the master record of the bill of material. ",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c59);

        Question c60 = new Question("Which of the following criteria can be used to determine the schedule line category? ",
                "MRP type and shipping point ",
                "Item category and MRP type ",
                "Item category group and strategy group ",
                "Item category and document type",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c60);

        Question c61 = new Question("Which of the following statements regarding partner determination are correct? Note: There are 2 correct answers to this question. ",
                "Partner determination procedures can be defined in sales documents at header, item, and schedule line level. ",
                "When creating a new partner function, it is possible to create new partner types. ",
                "The origin of partners that are automatically determined during the creation of sales documents is controlled using a condition type. ",
                "In a partner determination procedure, all possible partner functions are listed. ",
                "When creating a standard order, the permitted partners are automatically copied from the customer master to the document. ",
                null,
                null, null, null, "X", "X", null, Question.C_TSCM62_64);
        addQuestion(c61);

        Question c62 = new Question("A sales order is to be delivered with a material and quantity using TAN. Which of the following configuration settings are necessary? Note: There are 2 correct answers to this question. ",
                "The schedule line category needs be to set to relevant for delivery. ",
                "The item category needs to be set to relevant for delivery. ",
                "The sales document type needs to be set to relevant for delivery.",
                "The item category needs to be set to schedule line allowed. ",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c62);

        Question c63 = new Question("In a sales order, the schedule line category CP was found. The sales document item contains the following information: The MRP type from the material master is M0 and the relevant item category is TAN. The assignment table for schedule line categories has no entry for the combination of TAN and M0. In which of the following ways was the schedule line category determined in this case? ",
                "The system used the default schedule line category from the customizing of the sales document type. ",
                "The system used the default schedule line category assignment table using the criteria item category and SD document category. ",
                "The schedule line category was determined by the system in the assignment table with only the criteria item category. ",
                "The schedule line category was determined by the system in the assignment table using the criteria item category and item usage. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c63);

        Question c64 = new Question("Your sales document type has been configured with the following number systems:  " +
                " " +
                "Number range internal assignment:  01 Number range external assignment:  02 Item number increment: 10  Sub-item increment: 1  " +
                " " +
                "Which of the following statements relating to the above configuration settings are correct? Note: There are 2 correct answers to this question. ",
                "Sub-items of an exploded bill of material (BOM) list will be incrementally numbered with single digits. ",
                "When you manually enter a sales document number and save the sales document, a number from number range 01 will be assigned to the document. ",
                "When the sales order is saved, a new sequential document number will be generated by the number range 02. ",
                "The sales document can receive an external document number from number range 02 or an internally assigned document number. ",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c64);

        Question c65 = new Question("Which of the following parameters can be set in the schedule line category? Note: There are 3 correct answers to this question. ",
                "Shipping condition ",
                "Availability check ",
                "Transfer of requirements ",
                "Movement type ",
                "Delivery type ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c65);

        Question c66 = new Question("Which of the following basic functions can be assigned to a schedule line category? ",
                "Partner determination ",
                "Material determination ",
                "Incompleteness",
                "Listing/exclusion ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c66);

        Question c67 = new Question("Which of the following configuration settings is a prerequisite to ensure the explosion of a bill of material in the sales document? ",
                "The schedule line category of the main item must have the correct settings to allow the explosion of the bill of material.",
                "The item category of the main item must have the correct settings to allow the explosion of the bill of material. ",
                "For the sub-item components of the bill of material, a suitable item category must be determined using the item usage: BOM. ",
                "When customizing the sales document type, the checkbox Bill of material explosion must be set accordingly. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c67);

        Question c68 = new Question("You receive a request that the system be able to search for available quotations automatically for customers when sales order items are entered. Which of the following settings must you choose to allow this to happen? ",
                "The quotation messages function must be set in the quotation sales document type. ",
                "The completion rule must be set accordingly in the item category of the quotation. ",
                "The quotation messages function must be set in the sales order document type.",
                "The field reference document number must be listed in the incompleteness procedure of the sales order item category. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c68);

        Question c69 = new Question("Which of the following statements relating to shipping are correct? Note: There are 2 correct answers to this question. ",
                "The items of a delivery can be processed using various shipping points. ",
                "Each delivery must have a unique ship-to party. ",
                "The valid route is determined in the order header. ",
                "The organizational unit plant is responsible for the planning, execution, and monitoring of the shipping activities.",
                "The shipping point is determined for each order item. ",
                null,
                null, "X", null, null, "X", null, Question.C_TSCM62_64);
        addQuestion(c69);

        Question c70 = new Question("Which of the following pieces of information can be changed when you create an outbound delivery with reference to a sales order? Note: There are 3 correct answers to this question. ",
                "The weight ",
                "The ship-to party ",
                "The plant ",
                "The delivery quantity ",
                "The planned goods issue date ",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM62_64);
        addQuestion(c70);

        Question c71 = new Question("During the creation of the delivery document, the delivery can perform checks at item level to ensure compliance with the business requirements. Which elements can be checked by the system? Note: There are 3 correct answers to this question. ",
                "Over delivery ",
                "Zero quantity ",
                "Shipping conditions ",
                "Delivery priority ",
                "Minimum quantity ",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM62_64);
        addQuestion(c71);

        Question c72 = new Question("Which of the following statements relating to the post goods issue process are correct? Note: There are 3 correct answers to this question. ",
                "The post goods issue process leads to a change in value of the corresponding stock accounts in accounting. ",
                "The post goods issue process reduces the corresponding requirements in the materials planning. ",
                "The post goods issue process is executed with reference to the respective sales order. ",
                "The post goods issue process reduces the stock level. ",
                "After the post goods issue process is initiated, the system can begin to pack the materials. ",
                null,
                "X", "X", null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c72);

        Question c73 = new Question("Your customer wants to use warehouse transfer orders to perform a simple picking process during delivery processing. Which of the following would allow you to achieve this business requirement? Note: There are 3 correct answers to this question. ",
                "You must activate the assigned warehouse as a lean warehouse. ",
                "In the organizational structure, you must assign a warehouse to a combination of plant and storage location. ",
                "You must make the sales document type active for Warehouse Management. ",
                "You must maintain the determination of the picking location using MALA, RETA or MARE. ",
                "You must activate the storage location as picking relevant. ",
                null,
                "X", "X", null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c73);

        Question c74 = new Question("At your current project, you receive a request that special shipping costs should be entered in delivery documents, which will then be charged to the customer on the invoice. Which of the following must be done in order to fulfill this request? Note: There are 2 correct answers to this question.",
                "Maintain the Price Source field in copying control between the delivery and billing document on item level. ",
                "A pricing procedure must be defined and assigned to the delivery. ",
                "Ensure that sales prices and discounts are copied into the delivery. ",
                "Using the criteria: sales area, delivery type, and customer pricing procedure, determine a suitable pricing procedure. ",
                "The item category of the delivery document must be marked pricing relevant. ",
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c74);

        Question c75 = new Question("Which of the following settings can be chosen at delivery type level in relation to the picking process? ",
                "Which warehouse number will be proposed ",
                "Whether lean Warehouse Management is allowed ",
                "Delivery split by warehouse number ",
                "Whether items are relevant for picking ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c75);

        Question c76 = new Question("Which of the following can be identified as the most likely cause of a delivery split in a collective delivery run? ",
                "The physical weight of the total line items exceeds the capacity of the truck that is being used to deliver the product. ",
                "The shipping conditions of two separate items in the sales order differ from one another. ",
                "The loading group of one of the items in the sales order differs from the others. ",
                "The sales order line items have the same route and the same shipping point, but different ship to parties. ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_64);
        addQuestion(c76);

        Question c77 = new Question("Which of the following steps are included in the cash sales process? Note: There are 3 correct answers to this question. ",
                "When you save the cash sales, the system prints a document that can be given to the customer as an invoice. This invoice receipt is controlled with output type RD03. ",
                "The system does not print invoices during billing. ",
                "When you save the cash sales, the system automatically creates a delivery. ",
                "When you save the cash sales, the system prints a document that can be given to the customer as an order confirmation called BA00. ",
                "There is no need for a delivery because the customer is receiving the products immediately. ",
                null,
                "X", "X", "X", null, null, null, Question.C_TSCM62_64);
        addQuestion(c77);

        Question c78 = new Question("In which of the following ways do the sales document types rush order and cash sales differ? Note: There are 2 correct answers to this question. ",
                "For cash sales, you have to set a lead time for the requested delivery date in 7 days from today. For rush orders you have to set it for today's date. ",
                "When you save a cash sales document, the delivery is automatically created. For rush orders, this must be done manually. ",
                "For cash sales, you have to use a billing type which will post to the appropriate cash accounts. For a rush order, you can use a standard billing type for invoicing. ",
                "For cash sales, the customer receives an invoice output instead of an order confirmation output. For rush sales, this is not done. ",
                "For cash sales, the delivery creation is not necessary. For rush orders, the delivery creation is necessary. ",
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_64);
        addQuestion(c78);

        Question c79 = new Question("Which of the following is the difference between the SAP sales documents Delivery Free Of Charge and Subsequent Delivery Free Of Charge? ",
                "The SAP sales document Subsequent Delivery Free-Of-Charge requires a mandatory reference to a sales document. The SAP sales document, Delivery Free-Of-Charge does not have this requirement.  ",
                "The SAP sales document Delivery Free-Of-Charge must be created with reference to a preceding invoice. The SAP sales document Subsequent Delivery Free-Of-Charge can be created with reference to an invoice or sales order",
                "The SAP sales document Subsequent Delivery Free-Of-Charge uses the billing type 'Pro Forma Invoice for Delivery' (F8). The SAP sales document Delivery Free-Of-Charge is not invoiced.",
                "The SAP sales document Subsequent Delivery Free-Of-Charge uses the item category KLN, which carries out no pricing and no billing. The SAP sales document Delivery Free-Of-Charge uses the item category TAN, which carries out pricing and billing. ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c79);

        Question c80 = new Question("Which of the following statements about consignment fill-up is correct?",
                "The material remains in the valuated stock of the delivering plant even after the consignment fill-up. ",
                "In the consignment fill-up, the corresponding material becomes property of the customer only after the goods issue. ",
                "The consignment fill-up is relevant for billing. ",
                "For the consignment fill-up, a particular movement type is defined in the item category of the outbound delivery. ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_64);
        addQuestion(c80);


        Question d1 = new Question("Which of the following elements can directly influence whether an availability check will be performed? (Choose two) ",
                "The schedule line category in the sales document ",
                "The delivery type ",
                "The check group in the material master ",
                "The item category in the sales document",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d1);

        Question d2 = new Question("Based on which of the following dates is the availability check (ATP) carried out? ",
                "Requested delivery date ",
                "Replenishment lead date ",
                "Material availability date ",
                "Goods issue date",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d2);

        Question d3 = new Question("According to the system there is no stock available, but you still receive a confirmed schedule line in the sales order. What is the reason for this confirmation? ",
                "The availability check that was carried out included a replenishment lead time in the scope of check. ",
                "The system automatically searches other plants for inventory and transfers this inventory to the plant with zero inventory in the sales order. ",
                "The availability check was carried out, and on saving, the system immediately rescheduled the sales order according to the customer priority. ",
                "Inventory Management creates a stock transfer when the sales order is saved.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d3);

        Question d4 = new Question("If the material entered in the sales order is not available, how is the user alerted to this situation? ",
                "The incompletion log displays the unconfirmed schedule line as a missing field. ",
                "The availability control screen is displayed. ",
                "The schedule line is marked and highlighted by the system. ",
                "An error message appears on the status bar alerting the user to the situation.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d4);

        Question d5 = new Question("As a member of the project team, you are asked to set up the system so that user has to enter an order reason when processing a sales order. It should be possible to save the incomplete order, but further processing should not be possible until the Order Reason field is filled. How do you implement this requirement? ",
                "You define an incompletion procedure with the Order Reason field and mark it as mandatory. ",
                "You define an incompletion procedure with the Order Reason field and assign a status group in which the fields General, Delivery, and Billing Document are selected. ",
                "You define an incompletion procedure with the Order Reason field, assign it to the sales document type, and set the status to \"released for further process steps\". ",
                "You define an incompletion procedure with the Order Reason field and assign it to a sales document type that has the \"Incompletion Message\" indicator set.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d5);

        Question d6 = new Question("Which of the following statements regarding material determination are correct? (Choose two) ",
                "The definition of the substitution reason determines whether a manual or an automatic substitution process should be used. ",
                "Condition tables must be defined in Customizing (IMG). ",
                "The relevant substitution reason is specified in the access sequence. ",
                "The material determination procedure is assigned to a combination of sales areas, customer pricingprocedures, and document pricing procedures.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d6);

        Question d7 = new Question("You want to restrict the materials a customer can order. What do you use to achieve this? ",
                "Material listing ",
                "Product hierarchy ",
                "Material group ",
                "Assortment module",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d7);

        Question d8 = new Question("Which of the following statements regarding the free goods process is correct? ",
                "Free goods with an exclusive bonus quantity must contain the same material for both the ordered goods and the free goods. ",
                "Free goods with an inclusive bonus quantity will always be generated without a subitem. ",
                "The free goods calculation rule only allows for whole unit free goods bonus increments. ",
                "Free goods with an exclusive bonus quantity will always be generated with a subitem.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d8);

        Question d9 = new Question("How are Enterprise Services (ES) for the SAP Business Suite made available to the customer? ",
                "Via Enhancement Packages ",
                "Via Add-ons ",
                "Via Support Packages ",
                "Via Best Practices",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d9);

        Question d10 = new Question("Which SAP NetWeaver component ensures company-wide unification of data and information in heterogeneous IT environments? ",
                "Enterprise Portal",
                "Knowledge Management ",
                "Enterprise Search ",
                "Master Data Management",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d10);

        Question d11 = new Question("What Service Desk feature provides all the functions to analyze and monitor an entire SAP solution centrally? ",
                "Root cause analysis ",
                "Implementation Roadmap ",
                "SAP Notes ",
                "SAP Solution Manager diagnostics",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d11);

        Question d12 = new Question("Which SAP NetWeaver component realizes cross-system application processes? ",
                "SAP Exchange Infrastructure (SAP XI) / SAP Process Integration (SAP PI) ",
                "SAP Enterprise Portal (SAP EP)",
                "SAP Master Data Management (SAP MDM)",
                "SAP Business Warehouse (SAP BW)",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d12);

        Question d13 = new Question("A customer is to be billed on the last day of every month, regardless of when the order and the delivery are processed. Which procedure fulfills this requirement? ",
                "Maintain a factory calendar with a single date per month and assign it to the customer master record of the payer. ",
                "Maintain a billing date profile and assign it to the sales document type. ",
                "Maintain a customer-specific billing due list variant and schedule a periodic job. ",
                "Use the condition technique and assign a billing date determination profile to the customer master record of the payer.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d13);

        Question d14 = new Question("Which complaint request document is created with a mandatory reference to a billing document? ",
                "Invoice correction request",
                "Returns",
                "Credit memo request ",
                "Debit memo request",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d14);

        Question d15 = new Question("What data elements that are delivered with the SAP standard configuration represent split criteria in billing creation? (Choose three) ",
                "Payer",
                "Material group ",
                "Billing date ",
                "Ship-to party ",
                "Terms of payment",
                null,
                "X", null, "X", null, "X", null, Question.C_TSCM62_65);
        addQuestion(d15);

        Question d16 = new Question("What is the purpose of using billing due lists? (Choose two) ",
                "To initiate a dunning run in Financials ",
                "To process sales orders and deliveries that are due for billing ",
                "To periodically create billing documents ",
                "To release orders that are blocked for billing",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d16);

        Question d17 = new Question("What is controlled by the configuration of the billing type? ",
                "How account determination takes place ",
                "Whether a billing plan is determined when using this billing type ",
                "How the item category within the billing document is determined ",
                "Whether order-related billing is supported when using this billing type",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d17);

        Question d18 = new Question("Your finance team wants sales revenues for customers of affiliated companies to be posted to a different sales revenue account in the general ledger. Which of the following steps are required to allow this? (Choose three) ",
                "Create an account condition master record for the customers of affiliated companies. ",
                "Maintain the requested sales revenue account directly in the customer master record of the payer. ",
                "Assign the affected sales revenue account to the key combination in Customizing that includes the account assignment group field. ",
                "Assign an access that includes the account assignment group as a key field within the access sequence used for account determination.",
                "Assign the same predefined account assignment group to the customer master for all customers of affiliated companies.",
                null,
                null, null, "X", "X", "X", null, Question.C_TSCM62_65);
        addQuestion(d18);

        Question d19 = new Question("Using rental contracts, which settings are mandatory for working with periodic billing? (Choose two) ",
                "Maintenance of a factory calendar that is assigned to the customer master ",
                "Assignment of a billing plan type to the item category of the rental contract item ",
                "Maintenance of a separate billing type that is assigned to the sales document type of the rental contract ",
                "Assignment of the respective billing relevance (order-relevant billing '' billing plan) to the item category of the rental contract item",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d19);

        Question d20 = new Question("After you have saved the billing document, the following message appears in the status bar: Document 90036111 saved (no accounting document generated). What are the possible reasons why no accounting document has been created? (Choose two) ",
                "A posting block was set for the billing document type. This prevents the creation of the FI accounting documents. However, controlling documents were generated. ",
                "The reference number and assignment number differ. Therefore, accounting documents cannot be generated. ",
                "In the billing type used, there is a configured posting block. Therefore, the blocked billing document has to be released.",
                "The account determination cannot determine an account, or determines an account that cannot be posted to automatically.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d20);

        Question d21 = new Question("What is a prerequisite for using down payments in an integrated SD-FI down payment process? ",
                "A sales order must be created with an installment plan that uses terms of payment to control the down payment. ",
                "The requested down payment is determined as a separate item in the sales order by using item category determination. ",
                "The standard billing type F2 must be used in the billing plan for the down payment.",
                "A sales order must be created with a milestone billing plan that contains the required down payment billing type and date.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d21);

        Question d22 = new Question("In addition to the external balance sheet, you want to create an internal balance sheet based on additional criteria - particularly with regard to divisions. How do you fulfill this requirement? ",
                "Create business areas and use the condition technique for the determination logic. ",
                "Create business areas and assign them directly to company codes. ",
                "Create an additional company code that is flagged as relevant for the internal balance sheet. ",
                "Create business areas and assignment rules to determine the particular business area.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d22);

        Question d23 = new Question("Your customers submit payment for open accounts receivables by referring to the sales order document number, not the invoice number. Therefore, you maintain the Customizing settings so that the sales document number is transferred as the reference number in the FI accounting document. What do you need to consider when transferring the sales order document number as a reference number to Financial Accounting (FI)? ",
                "The sales revenues will be posted to a different account in FI when using the sales order number as the reference number. ",
                "Using the sales order number as the reference number will lead to a posting block. Billing documents will have to be released for transfer to FI. ",
                "You have to maintain copy control entries from sales orders to billing documents in Customizing. ",
                "Using the sales order number as a reference number could lead to an invoice split.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d23);

        Question d24 = new Question("Which statements regarding the cancellation of billing documents are correct? (Choose two) ",
                "During the cancellation process, a posting is made in Financial Accounting, but the system does not cancel the invoice.",
                "When saving the cancellation document, the corresponding posting is automatically executed in Financial Accounting. ",
                "When creating the cancellation document, it is possible to change the pricing conditions. ",
                "Only line items that are already cleared in Financial Accounting can be cancelled. ",
                "The cancellation of a billing document leads to resetting the billing status of the originally billed delivery or sales order.",
                null,
                null, "X", null, null, "X", null, Question.C_TSCM62_65);
        addQuestion(d24);

        Question d25 = new Question("Which statements relating to output processing are correct? (Choose two) ",
                "Each output type can have only one transmission medium assigned to it. ",
                "The access sequence of the output determination procedure defines which document data is shown in the output presentation. ",
                "If you want to include new document fields in an output, you must enhance the form that is assigned to the output type. ",
                "The permitted transmission mediums are assigned to the output type in Customizing.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d25);

        Question d26 = new Question("What can you do if you configure only the account group? ",
                "You can determine the account determination procedure. ",
                "You can hide fields in the customer master. ",
                "You can define two number ranges per account group. ",
                "You can create and add new fields to the customer master.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d26);

        Question d27 = new Question("Only texts of a specific text type should be printed using a SAPscript form. Which configuration is required?",
                "The text type has to be flagged as relevant for printing. ",
                "The text type has to be included in a new print output program. ",
                "The text type has to be included in the relevant form. ",
                "The text type has to be assigned directly to the relevant access sequence.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d27);

        Question d28 = new Question("Which statement regarding the copy control is correct? ",
                "The copy control for sales documents controls the transfer of data at header, item, and schedule line level. ",
                "The copy control allows you to create sales documents with reference to other sales documents, delivery documents, and billing documents. ",
                "The item category of the target document must always be specified in the copy control. ",
                "The pricing in the source document is changed automatically when you create a sales document with reference and change the pricing.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d28);

        Question d29 = new Question("During quotation processing, a new quotation header text should be entered by the users. Which configuration is necessary? ",
                "An access sequence has to be assigned to the text object.",
                "You have to decide whether texts are referenced or copied for the relevant item categories. ",
                "A new text type has to be created and assigned to the respective document type.",
                "A new text type has to be created and added to the respective text determination procedure.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d29);

        Question d30 = new Question("What part of the text control directly determines the copying of a text from a source text object into another text type? ",
                "Condition table ",
                "Text determination procedure ",
                "Access sequence ",
                "Text type",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d30);

        Question d31 = new Question("For what purposes can you use transaction variants? (Choose two) ",
                "To define values in a selection screen for a report",
                "To add new external fields to the sales document ",
                "To hide fields in a sales order ",
                "To define default values for data fields",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d31);

        Question d32 = new Question("What do you have to consider when configuring the sales process \"quotation sales order\"? (Choose two) ",
                "Set up the item category of the quotation so that it is created with mandatory reference to a sales order. ",
                "Define the \"Default Item Category\" in copying control for all manually maintained item categories in the quotation. ",
                "Specify how pricing data should be handled when copying items. ",
                "Define the item category of the quotation as relevant for ordering.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d32);

        Question d33 = new Question("Which of the following functions can be used to display an overview of customer-specific prices for various customers on one screen? ",
                "Pricing log ",
                "Net price list ",
                "Pricing analysis ",
                "Pricing report",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d33);

        Question d34 = new Question("In which of the following master records can partial delivery agreements be stored? (Choose two) ",
                "In the customer material info record ",
                "In the material master record ",
                "In the condition master record ",
                "In the customer master record",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d34);

        Question d35 = new Question("Which of the following statements regarding the material master data are correct? (Choose two) ",
                "The following information in a sales order is derived from the material master: material group,weight, and item category. ",
                "The control tool for the material master is the material type. It needs to be selected whenever you create a new material master record. ",
                "The sales views of the material master data can be maintained for various combinations of sales organization and distribution channel. ",
                "If a delivering plant is defined in the sales data of the material master, this plant is transferred to a corresponding sales document item and can no longer be changed.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d35);

        Question d36 = new Question("Which of the following statements about customer master data are correct? (Choose two) ",
                "Address changes in the customer master affect existing documents in the system. ",
                "The customer master is created using an account group. ",
                "The customer master data is transferred to the sales order and cannot be changed there. ",
                "The customer master is subdivided into general data, company code data, sales area data, and plant data.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d36);

        Question d37 = new Question("When you create a new sales order, which master data is automatically copied to the sales order? (Choose two) ",
                "The terms of payment from the sales area data of the bill-to party ",
                "The terms of payment from the company code data",
                "The agreement on partial deliveries from the sales area data of the ship-to party ",
                "The incoterms from the sales area data of the sold-to party",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d37);

        Question d38 = new Question("What are the consequences when you change the payer at header level in a sales order? (Choose two) ",
                "Any additional sales order items are given the payment terms for the new payer. ",
                "The partner function \"Payer\" is changed in the sold-to customer master.",
                "Receivables resulting from the sales order are posted to the new payer. ",
                "The billing document (invoice) is automatically sent to the new payer.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d38);

        Question d39 = new Question("What is the purpose of the moving price or standard price on the Accounting view in the material master? (Choose two) ",
                "To define the value that is used when posting the receivables for a customer ordering this material ",
                "To determine the value that is used for the accounting document when posting goods issue",
                "To display statistical information for the costs in the pricing environment of a sales order ",
                "To define the sales price that is used when selling this material to a customer",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d39);

        Question d40 = new Question("Which of the following statements regarding condition records are correct? (Choose three) ",
                "A lower and upper limit can be defined for each condition record.",
                "The scale basis can be structured based on value, quantity or other parameters. ",
                "Condition records can be maintained for all condition types that have an access sequence assigned to them. ",
                "Changing a condition within the sales order that was determined automatically by the system leads to an update of the respective condition record master data. ",
                "The number of scale levels within condition records is limited to a maximum of five.",
                null,
                "X", "X", "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d40);

        Question d41 = new Question("Which of the following statements regarding the function of distribution channels is correct? ",
                "A distribution channel has its own address. ",
                "The maintenance of distribution channels is optional and is not necessary for single-level enterprise structures. ",
                "The distribution channel can be used to distinguish material master data used during sales order processing. ",
                "Each shipping point requires its own distribution channel.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d41);

        Question d42 = new Question("Assigning sales organizations to company codes builds integration between SD and FI. Which of the following statements regarding the assignment of sales organizations to company codes are correct? (Choose two) ",
                "Sales organizations are assigned to company codes indirectly using the sales area.",
                "Several sales organizations can be assigned to one company code. ",
                "Each sales organization is assigned to just one company code.",
                "A sales organization can be assigned to several company codes.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d42);

        Question d43 = new Question("Which of the following statements regarding the organizational assignment of plants are correct? (Choose three) ",
                "Several plants can be assigned to one company code. ",
                "A plant can be assigned to multiple company codes. ",
                "A plant must be assigned to at least one combination of sales organization and distribution channel so that it can be used as a delivering plant. ",
                "Delivering plants must be assigned to the same company code as the sales organization. ",
                "Each plant can be assigned to just one company code.",
                null,
                "X", null, "X", null, "X", null, Question.C_TSCM62_65);
        addQuestion(d43);

        Question d44 = new Question("Which of the following criteria influence the shipping point determination in the sales document? (Choose three) ",
                "Plant",
                "Storage condition ",
                "Loading group ",
                "Shipping condition ",
                "Division",
                null,
                "X", null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d44);

        Question d45 = new Question("You are using customer hierarchies. The discount HI01 should be based on the values maintained on the different nodes of a customer hierarchy. Which option allows you to integrate this discount into your pricing strategy? ",
                "Setting the hierarchy flag within the condition record of HI01 for the main node. This allows the maintenance and automatic determination of discounts based on different sub-level nodes of a customer hierarchy. ",
                "Implementing a pricing procedure that contains the condition type HI01 several times according to the number of levels of your customer hierarchy. You also need to set a priority within the pricing procedure. ",
                "Assigning an access sequence to the condition type HI01 consisting of multiple accesses using the same condition table. During each access, a different node is filled as the document field in the source field HIENR. ",
                "Setting condition type HI01 as a structure condition. You can maintain records based on this condition for the different hierarchy nodes. These will then be found automatically by the system.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d45);

        Question d46 = new Question("Your sales representative wants to enter a discount that should only be entered manually within the pricing screen of a sales order in addition to the conditions that were automatically determined. In which of the following ways do you implement this business requirement? (Choose two) ",
                "Ensure that the condition type exists in the pricing procedure used in the sales order. ",
                "Mark the condition type within the pricing procedure as a manual condition. ",
                "Assign an access sequence to the condition type. ",
                "Maintain a condition record for the discount that should be entered manually.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d46);

        Question d47 = new Question("What elements are necessary to determine the pricing procedure in a sales document? (Choose three) ",
                "Document pricing procedure of the sales document type ",
                "Customer pricing procedure from the customer master ",
                "Condition master data ",
                "Sales area ",
                "Account assignment group from the customer master",
                null,
                "X", "X", null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d47);

        Question d48 = new Question("You have maintained condition records for a sales discount on different levels. If multiple condition records for this discount are found within a sales order, only the best condition for the customer should be active. How do you implement this business requirement? ",
                "Implement hierarchy accesses. ",
                "Maintain condition exclusions. ",
                "Maintain a separate pricing procedure. ",
                "Use group conditions.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d48);

        Question d49 = new Question("How do the condition type and condition records for rebate agreements vary in comparison to condition types and records for standard discounts? (Choose two) ",
                "In the usage of different condition classes ",
                "In the maintenance of scales ",
                "In the maintenance of accrual rates within condition records ",
                "In the usage of different calculation types",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d49);

        Question d50 = new Question("In future, your sales representatives should be able to maintain freight costs as condition records based on the sales organization, distribution channel, incoterms (part 1), and destination country. At present, this level of maintenance is not supported at all in your system. Which object do you need to maintain in Customizing to allow this feature in condition maintenance?",
                "Condition table ",
                "Access sequence ",
                "Pricing procedure ",
                "Condition type",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d50);

        Question d51 = new Question("You have been asked to change a process so that during sales invoicing, any manually changed pricing elements in the pricing procedure for the sales document are copied from the sales order to the billing document unchanged, but other automatically determined conditions are redetermined. Where is this behavior controlled? ",
                "In the copy control at item level ",
                "In the billing type ",
                "In the condition type ",
                "In the item category of the billing type",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d51);

        Question d52 = new Question("You have set up the condition type K029 as a gross weight-calculated discount based on the material group. You now want to implement this for ordered materials belonging to the same material group. The system should accumulate the gross weight of the items to determine the scale rate. For the required weight accumulation, what function should be used for condition type K029? ",
                "Structure condition ",
                "Condition supplements ",
                "Group condition ",
                "Scale basis",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d52);

        Question d53 = new Question("Which configuration setting is a prerequisite to ensure the explosion of a bill of material in the sales document? ",
                "The schedule line category of the main item must have the correct settings to allow the explosion of the bill of material. ",
                "The item category of the main item must have the correct settings to allow the explosion of the bill of material. ",
                "A suitable item category must be determined for the sub-item components of the bill of material using the item usagE.BOM. ",
                "When customizing the sales document type, the Bill of material explosion checkbox must be set accordingly.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d53);

        Question d54 = new Question("Which of the following statements regarding quantity contracts is correct?",
                "Quantity contract items will show up in the delivery due list when ready for delivery. ",
                "Different requested delivery dates are maintained in the schedule lines of the quantity contract. ",
                "Quantity contracts contain details about the customer's requested delivery dates. ",
                "Quantity contracts are delivered using a contract release order.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d54);

        Question d55 = new Question("What is used to determine the item category for general value contracts (WK1)? ",
                "Item category group ",
                "Value contract material ",
                "You do not need to determine item categories for value contracts ",
                "Item usage VCTR",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d55);

        Question d56 = new Question("What parameters can be set in the schedule line category? (Choose three) ",
                "Availability check ",
                "Movement type",
                "Delivery type ",
                "Transfer of requirements ",
                "Shipping condition",
                null,
                "X", "X", null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d56);

        Question d57 = new Question("What statements regarding partner determination are correct? (Choose two) ",
                "The origin of partners that are automatically determined during the creation of sales documents is controlled using a condition type. ",
                "When creating a new partner function, it is possible to create new partner types. ",
                "Partner determination procedures can be defined in sales documents at header, item, and schedule line level. ",
                "In a partner determination procedure, all possible partner functions are listed. ",
                "When creating a standard order, the permitted partners are automatically copied from the customer master to the document.",
                null,
                null, null, null, "X", "X", null, Question.C_TSCM62_65);
        addQuestion(d57);

        Question d58 = new Question("Which statement about consignment fill-up is correct? ",
                "In the consignment fill-up, the corresponding material becomes the property of the customer only after the goods issue. ",
                "The material remains in the valuated stock of the delivering plant even after the consignment fill-up. ",
                "The consignment fill-up is relevant for billing.",
                "For the consignment fill-up, a particular movement type is defined in the item category of the outbound delivery.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d58);

        Question d59 = new Question("Your sales document type has been configured with the following number systems: Number range internal assignment: 01 Number range external assignment: 02 Item number increment: 10 Sub-item increment: 1 Which statements regarding the above configuration settings are correct? (Choose two) ",
                "When you enter a sales document number manually and save the sales document, a number from number range 01 is assigned to the document.",
                "Sub-items in an exploded bill of material (BOM) list are numbered with increments of one. ",
                "When the sales order is saved, a new sequential document number is generated by the number range 02. ",
                "The sales document can receive an external document number from number range 02 or an internally assigned document number.",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d59);

        Question d60 = new Question("What are differences between value contracts and scheduling agreements? (Choose two) ",
                "Value contracts contain both a target quantity and a target value.",
                "Value contracts can be created without item categories. ",
                "Value contracts require release orders. ",
                "Value contracts cannot perform an availability check (ATP). ",
                "Value contracts have schedule lines.",
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d60);

        Question d61 = new Question("What steps are included in the cash sales process? (Choose three) ",
                "When you save the cash sales, the system prints a document that can be given to the customer as an invoice. This document is controlled with output type RD03. ",
                "There is no need for a delivery because the customer receives the products immediately. ",
                "When you save the cash sales, the system prints a document - BA00 - that can be given to the customer as an order confirmation. ",
                "When you save the cash sales, the system automatically creates a delivery.",
                "The system does not print invoices during billing.",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM62_65);
        addQuestion(d61);

        Question d62 = new Question("What is the difference between the SAP sales documents \"Delivery Free-of-Charge\" and \"Subsequent Delivery Free-of-Charge\"? ",
                "Subsequent Delivery Free-of-Charge uses the item category KLN, which carries out no pricing and no billing. Delivery Free-of-Charge uses the item category TAN, which carries out pricing and billing. ",
                "Delivery Free-of-Charge must be created with reference to a preceding invoice. Subsequent Delivery Free-of-Charge can be created with reference to an invoice or sales order. ",
                "Subsequent Delivery Free-of-Charge uses the billing type 'Pro Forma Invoice for Delivery' (F8). Delivery Free-of-Charge is not invoiced. ",
                "Subsequent Delivery Free-of-Charge requires a mandatory reference to a sales document. Delivery Free-of-Charge does not have this requirement.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d62);

        Question d63 = new Question("How do the sales document types \"rush order\" and \"cash sales\" differ? (Choose two) ",
                "For cash sales, the customer receives an invoice output instead of an order confirmation output. For rush sales, this is not done. ",
                "For cash sales, delivery creation is not necessary. For rush orders, delivery creation is necessary. ",
                "When you save a cash sales document, the delivery is created automatically. For rush orders, this must be done manually. ",
                "For cash sales, you have to use a billing type which will post to the appropriate cash accounts. For a rush order, you can use a standard billing type for invoicing.",
                "For cash sales, you have to set a lead time for the requested delivery date of 7 days from today. For rush orders you have to set it for today's date.",
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d63);

        Question d64 = new Question("You are requested to set the system in such a way that it can automatically search for available quotations for customers when sales order items are entered. What do you have to do to make this happen? ",
                "Set the completion rule in the item category for the quotation. ",
                "List the reference document number field in the incompleteness procedure for the sales order item category. ",
                "Set the quotation messages function in the sales order document type. ",
                "Set the quotation messages function in the quotation sales document type.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d64);

        Question d65 = new Question("In a sales order, the schedule line category CP was found. The sales document item contains the following information: The MRP type from the material master is M0 and the relevant item category is TAN. The assignment table for schedule line categories has no entry for the combination of TAN and M0. How was the schedule line category determined in this case? ",
                "The schedule line category was determined by the system in the assignment table with only the criteria item category. ",
                "The schedule line category was determined by the system in the assignment table using the item category and item usage criteria. ",
                "The system used the default schedule line category assignment table with the item category and SD document category criteria. ",
                "The system used the default schedule line category from the Customizing of the sales document type.",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d65);

        Question d66 = new Question("A sales order is to be delivered with a material and quantity using TAN. What configuration settings are necessary? (Choose two) ",
                "The item category needs to be set to relevant for delivery. ",
                "The sales document type needs to be set to relevant for delivery. ",
                "The schedule line category needs be to set to relevant for delivery. ",
                "The item category needs to be set to schedule line allowed.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d66);

        Question d67 = new Question("What is controlled by the item category of a sales document item? (Choose three) ",
                "Whether an item is relevant for billing ",
                "Whether the availability check is performed ",
                "Whether an item is relevant for pricing ",
                "Whether schedule line items are allowed ",
                "Whether an item is relevant for rejection and a reason for rejection is assigned to it",
                null,
                "X", null, "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d67);

        Question d68 = new Question("Which document flows describe possible standard sales processes? (Choose two)",
                "Inquiry - Quotation - Value contract - Order with reference to the value contract - Invoice Accounting document ",
                "Standard order with reference to a Quotation - Delivery - Transfer order - Post goods issue Invoice - Accounting document ",
                "Inquiry - Quotation '' Order - Transfer order - Post goods issue - Invoice - Accounting document ",
                "Invoice correction request with reference to a standard order - Delivery - Transfer order - Post goods issue - Invoice - Accounting document",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d68);

        Question d69 = new Question("Which of the following statements regarding the bills of material (BOM) in the sales order are correct? (Choose two) ",
                "Bills of material are maintained as master data. The bill of material is flagged as \"BOM usage sales and distribution\". ",
                "The depth of the explosion of bills of material in the sales document is controlled by specifying the explosion level in the master record for the bill of material. ",
                "The sales document type controls whether bills of material relevant to sales are to be exploded in the sales document or not. ",
                "Bills of material are exploded in the sales document as main items and sub-items based on the configuration of the main item category.",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d69);

        Question d70 = new Question("When the delivery document is created, the system can perform checks at item level to ensure compliance with the business requirements. Which elements can be checked by the system? (Choose three) ",
                "Overdelivery",
                "Zero quantity ",
                "Delivery priority ",
                "Shipping conditions ",
                "Minimum quantity",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM62_65);
        addQuestion(d70);

        Question d71 = new Question("What can be identified as the most likely reason for a delivery split in a collective delivery run?",
                "The shipping conditions of two separate items in the sales order differ from one another. ",
                "The sales order line items have the same route and the same shipping point, but different shipto parties. ",
                "The physical weight of the total line items exceeds the capacity of the truck that is being used to deliver the product. ",
                "The loading group of one of the items in the sales order differs from the others.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d71);

        Question d72 = new Question("What can you determine for the picking process at delivery type level? ",
                "Which warehouse numbers will be proposed ",
                "Whether lean warehouse management is allowed",
                "Which rule is used to determine the picking location ",
                "Whether items are relevant for picking",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d72);

        Question d73 = new Question("Your customer wants to use warehouse transfer orders for picking when processing a delivery using lean warehouse management. How do you achieve this? (Choose two) ",
                "Activate the sales document type for warehouse management. ",
                "Activate the sales document type for lean warehouse management. ",
                "Activate the storage location as relevant for picking.",
                "Activate the assigned warehouse number as a lean warehouse. ",
                "Assign a warehouse number to a combination of plant and storage location in the organizational structure.",
                null,
                null, null, null, "X", "X", null, Question.C_TSCM62_65);
        addQuestion(d73);

        Question d74 = new Question("You are asked to enter special shipping costs in delivery documents, which will then be charged to the customer on the invoice. What must be done to fulfill this request? (Choose two) ",
                "Maintain the Price Source field in copying control between the delivery and billing document at item level. ",
                "A pricing procedure must be defined and assigned to the delivery type. ",
                "Determine a suitable pricing procedure using the criteriA.sales area, delivery type, and customer pricing procedure. ",
                "Ensure that sales prices and discounts are copied to the delivery.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d74);

        Question d75 = new Question("What settings are mandatory when implementing a packing process based on the delivery? (Choose two) ",
                "Automatic packing must be activated for the relevant delivery item categories. ",
                "For each delivery item category, you have to decide whether the item may be packed, cannot be packed, or must be packed. ",
                "Material master records have to be created for the different packaging materials. ",
                "Packing instructions that determine the packaging materials and the rounding rules must be created.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM62_65);
        addQuestion(d75);

        Question d76 = new Question("Which statements regarding the post goods issue process are correct? (Choose three) ",
                "The post goods issue process leads to a change in value of the corresponding stock accounts in accounting. ",
                "The post goods issue process reduces the stock level.",
                "After the post goods issue process is initiated, the system can begin to pack the materials. ",
                "The post goods issue process is executed with reference to the respective sales order.",
                "The post goods issue process reduces the corresponding requirements in materials planning.",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM62_65);
        addQuestion(d76);

        Question d77 = new Question("What can be changed when you create an outbound delivery with reference to a sales order? (Choose three) ",
                "Plant",
                "Planned goods issue date ",
                "Weight",
                "Delivery quantity ",
                "Ship-to party",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM62_65);
        addQuestion(d77);

        Question d78 = new Question("Which of the following statements regarding delivery and transportation scheduling are correct? (Choose two) ",
                "The transportation lead time, pick/pack time, loading time, and transit time are taken into account for delivery and transportation scheduling. ",
                "The delivery and transportation dates determined in the order are visible at header level.",
                "On the calculated post goods issue date, the material requirements of the item are transferred to material requirement planning. ",
                "When the requested delivery date cannot be confirmed by backward scheduling, the order can still be saved.",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d78);

        Question d79 = new Question("Which statements regarding shipping are correct? (Choose two) ",
                "The valid route is determined in the order header. ",
                "Each delivery must have a unique ship-to party. ",
                "The organizational unit plant is responsible for the planning, execution, and monitoring of the shipping activities. ",
                "The shipping point is determined for each order item. ",
                "The items in a delivery can be processed using various shipping points.",
                null,
                null, "X", null, "X", null, null, Question.C_TSCM62_65);
        addQuestion(d79);

        Question d80 = new Question("Which of the following can be used to determine the schedule line category? ",
                "Item category ",
                "Item category with \"Schedule Line allowed\" indicator and MRP type ",
                "MRP type ",
                "Item category and document type",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM62_65);
        addQuestion(d80);

        Question e1 = new Question("You want to use the function \"Read PP master data\" in the production order.\n" +
                "However, while calling the function you receive an error message.\n" +
                "What could be the reason?\n",
                "The material availability check has been performed",
                "Goods movements have been posted.",
                "The production order has been released.",
                "Order papers have been printed.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e1);

        Question e2 = new Question("Which objects can affect the calculation of capacity requirements for an operation?(Choose three)\n",
                "Standard values (routing) ",
                "In-house production time (material master) ",
                "Transport time (routing) ",
                "Formulas (work center) ",
                "Operation control key (routing)",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_66);
        addQuestion(e2);

        Question e3 = new Question("In the Customizing for requirements planning, a project team notices that the alternatives P1, P2, P3 and P4 are also delivered as standard in addition to MRP type PD. The number in each of these alternatives represents a firming type.\n" +
                "What does a firming type define?(Choose two)\n",
                "Handling existing procurement proposals outside the planning time fence. ",
                "Handling existing procurement proposals within a planning time fence",
                "Handling new requirements within the planning time fence.",
                "Handling new procurement proposals that need to be created due to new requirements within the planning time fence.",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e3);

        Question e4 = new Question("Which of the following scheduling types can only be used in capacity planning?\n",
                "Midpoint ",
                "Forward ",
                "Only capacity requirements ",
                "Backward",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e4);

        Question e5 = new Question("Which types of objects can be changed with Engineering Change Management (ECM)?(Choose three)\n",
                "Task list ",
                "Work center ",
                "Production version ",
                "Bill of material ",
                "Material master",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_66);
        addQuestion(e5);

        Question e6 = new Question("Which of the following master data can be used with process orders?(Choose three)",
                "Serial numbers ",
                "Master recipes ",
                "Resources",
                "Production/resource tools ",
                "Production versions",
                null,
                null, "X", "X", null, "X", null, Question.C_TSCM42_66);
        addQuestion(e6);

        Question e7 = new Question("You want to use the different options for planning in SAP ECC.\n" +
                "What is the correct sequence of the planning procedures?\n",
                "Sales and operations planning -> Demand management -> Long-term planning -> Material requirements planning -> Capacity planning ",
                "Demand management -> Sales and operations planning -> Capacity planning -> Longterm planning -> Material requirements planning ",
                "Material requirements planning -> Demand management -> Sales and operations planning -> Long-term planning -> Capacity planning ",
                "Long-term planning -> Sales and operations planning -> Demand management -> Material requirements planning -> Capacity planning",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e7);

        Question e8 = new Question("Which activity can trigger an automatic availability check for the components of a production order?\n",
                "Material staging ",
                "Order rescheduling ",
                "Order release ",
                "Goods receipt for a missing part",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e8);

        Question e9 = new Question("You want to enhance the system statuses of a production order with user statuses.\n" +
                "How do you do this?",
                "Define the user statuses in the order type-dependent parameters",
                "Define a status profile in Customizing and assign it to the production scheduling profile. ",
                "Define a status profile in Customizing and assign it to the order type. ",
                "Define the user statuses in the Customizing table of the system statuses.\n",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e9);

        Question e10 = new Question("The final assembly of a finished product should only be triggered when a customer order arrives.\n" +
                "Which planning strategy for the finished product do you use?\n",
                "Planning with make-to-stock (strategy 10) ",
                "Planning at the assembly level (strategy 70) ",
                "Planning without final assembly (strategy 50) ",
                "Planning with final assembly (strategy 40)",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e10);

        Question e11 = new Question("What are the consequences of setting a production order to Technically Complete (TECO)?(Choose three)\n",
                "The order is no longer relevant for material requirements planning. ",
                "Capacity requirements are set to null. ",
                "Confirmations are no longer possible. ",
                "Reservations are no longer relevant for material requirements planning. ",
                "The order and its operations receive the system status Locked (LKD).",
                null,
                "X", "X", null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e11);

        Question e12 = new Question("What is SAP Solution Manager?\n",
                "A transaction in the SAP ECC system ",
                "A standalone system that communicates with other systems in a system landscape ",
                "An add-on industry solution ",
                "A managed system in a system landscape\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e12);

        Question e13 = new Question("You create a routing that includes five operations in an initial sequence (10, 20, 30, 40, 50). When capacity bottlenecks occur, you want to use a second sequence on other work centers for operations 30 and 40.\n" +
                "Which sequence category do you use to create the second sequence in the system?\n",
                "Finish-start relationship ",
                "Standard sequence ",
                "Parallel sequence ",
                "Alternative sequence",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e13);

        Question e14 = new Question("What could be a consequence of confirming an operation?\n",
                "The planned costs are updated ",
                "The capacity requirements are updated",
                "The production order is rescheduled ",
                "The actual costs are settled",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e14);

        Question e15 = new Question("When analyzing the SAP ECC order report for a planned order for a finished product, you discover that one of the assemblies will not be available in time for the scheduled final assembly because of automatic forward scheduling.\n" +
                "Which planning procedure do you use to create a feasible production plan from a requirements planning perspective?\n",
                "Total planning online ",
                "Multi-level single-item planning with the \"display material list\" option ",
                "Interactive single-item planning for the delayed assembly ",
                "Multi-level single-item planning with the \"simulation mode\" option\n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e15);

        Question e16 = new Question("Which of the following activities within the KANBAN procedure normally triggers subsequent stock posting of the goods receipt?\n",
                "Set \"Container in process\" ",
                "Set \"Container empty\" ",
                "Set \"Container in transport\" ",
                "Set \"Container full\" ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e16);

        Question e17 = new Question("What do you have to consider regarding ATP checks in SAP ECC that are triggered from customer orders?\n",
                "If the ATP check determines non-availability, it then checks in the next step whether timely procurement or production is possible. ",
                "The ATP quantity is the available quantity that can be used to confirm incoming customer orders. ",
                "An ATP check creates fixed links between customer orders and their confirmed receipts. ",
                "The ATP check does not take stocks and receipts into account. It checks consumption of planned independent requirements.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e17);

        Question e18 = new Question("After a material has been included in a NETCH material requirements planning run you change its BOM (bill of materials).\n" +
                "Which of the following planning file entries for this material are set by the system?",
                "The BOM explosion and the NETPL planning indicator ",
                "The BOM explosion indicator ",
                "The BOM explosion, the NETCH, and the NETPL planning indicators ",
                "The NETCH and NETPL planning indicators",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e18);

        Question e19 = new Question("What master data do you need for material replenishment using the KANBAN procedure?(Choose two)\n",
                "Production supply area ",
                "Rate routing ",
                "Product cost collector ",
                "Control cycle ",
                "Production version",
                null,
                "X", null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e19);

        Question e20 = new Question("For which of the following objects can you enter a confirmation?(Choose two)\n",
                "Work Center ",
                "Production order operation ",
                "Production order",
                "Trigger Point",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e20);

        Question e21 = new Question("The stock/requirements list for a finished product contains only one sales order and one fixed planned order with the same quantity. The availability dates for both MRP elements are on working days. The availability date for the fixed planned order is set to a later date than the one for the sales order.\n" +
                "However, a corresponding rescheduling exception message does not appear.\n" +
                "What could be the reasons?(Choose two)",
                "The delta between the availability dates falls within the tolerance window defined in Customizing. ",
                "The fixed planned order is outside the rescheduling horizon. ",
                "Requirements planning has not been carried out. ",
                "The MRP elements are linked via fixed pegging.",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e21);

        Question e22 = new Question("Which issue can occur if the lot size-dependent in-house production time in the material master is not updated after changing the routing?\n",
                "Lead time scheduling cannot take place. ",
                "Dependent requirements request the components from the bill of materials at wrong times when using basic dates scheduling. ",
                "Requirements planning creates an appropriate exception message in basic dates scheduling. ",
                "Subsequent capacity planning is no longer possible due to the obsolete scheduling parameters.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e22);

        Question e23 = new Question("Which of the following features are offered by MRP areas in SAP ECC?(Choose two)\n",
                "A storage location may be assigned to different MRP areas. ",
                "An MRP area may include different storage locations.",
                "Make-to-order production is supported by storage location MRP areas. ",
                "Subcontracting is supported by MRP areas.",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e23);

        Question e24 = new Question("Which functions can be triggered before releasing a production order?(Choose three)\n",
                "Selection of a routing ",
                "Selection of a BOM ",
                "Stock determination ",
                "Confirmation",
                "Scheduling",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM42_66);
        addQuestion(e24);

        Question e25 = new Question("You want to produce a finished product only when it is requested by a customer order in make-to-order production. However, all assemblies need to be procured beforehand.\n" +
                "How can you fulfill these requirements in SAP ECC?(Choose two)",
                "Use strategy 50 (planning without final assembly) for the finished product and no strategy for all assemblies in the bill of material. ",
                "Use strategy 30 (production by lots) for the finished product and strategy 70 (planning at the assembly level) for all assemblies in the bill of material. ",
                "Use strategy 20 (make-to-order production) for the finished product and strategy 70 (planning at the assembly level) for all assemblies in the bill of material. ",
                "Use strategy 40 (planning with final assembly) for the finished product and strategy 70 (planning at the assembly level) for all assemblies in the bill of material.",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e25);

        Question e26 = new Question("Which of the following properties about the planning functions available in SAP ECC applies?",
                "Long-term planning (LTP) is a long-term form of forecasting. ",
                "In demand management (DM) material shortage situations are identified and corresponding receipt elements are created.",
                "Material requirements planning (MRP) includes automatic capacity leveling. ",
                "Master production scheduling (MPS) refers to preferred planning of important materials.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e26);

        Question e27 = new Question("Where can you define the default storage location for the material component of a production order?(Choose three)\n",
                "Routing",
                "Production supply area of a work center ",
                "BOM header (product) ",
                "Production version (product) ",
                "Material master (component)",
                null,
                null, "X", null, "X", "X", null, Question.C_TSCM42_66);
        addQuestion(e27);

        Question e28 = new Question("You want to plan a finished material using material requirements planning in an SAP ECC system. The resulting planned orders should be scheduled using basic date scheduling (not lead-time scheduling).\n" +
                "Which of the following properties for the resulting dependent requirements applies?\n",
                "In multi-level backward scheduling, dependent requirements are calculated to the exact second. ",
                "If the individual material components are explicitly assigned to the operations of a routing, the requirement dates of the dependent requirements are scheduled at each start date of the operations. ",
                "When a customer order is created for the finished material, the dependent requirements are automatically triggered for the components in the bill of material without a planning run. ",
                "In multi-level backward scheduling, dependent requirements are triggered at the start date for the planned order of the finished material.",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e28);

        Question e29 = new Question("Which of the following properties applies to multi-site planning in SAP ECC?\n",
                "When using one-step stock transfer posting, transfer stock is created in the receiving plant. ",
                "Multi-site planning can be activated using the corresponding planning strategy. ",
                "Both withdrawal from an alternative plant and stock transfer from another plant are defined via special procurement keys. ",
                "The use of \"scope of planning\" is always mandatory for multi-site planning.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e29);

        Question e30 = new Question("During a project phase, your customer raises some questions concerning parameters of the procurement type in the material master in the SAP ECC system.\n" +
                "Which of the following procurement type properties are valid?(Choose two)\n",
                "If both procurement types are allowed with entry X (both procurement types), requirements planning assumes in-house production. ",
                "Procurement types E (in-house production) and F (external procurement) always have to be further refined with special procurement types. ",
                "Procurement types E (in-house production), F (external procurement), or X (both procurement types) can be selected for a material independent of the material type. ",
                "If procurement type E (in-house production) is set, external procurement may still be possible, depending on the material type.\n",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e30);

        Question e31 = new Question("Which of the following statements best defines SAP ERP?\n",
                "SAP ERP is an application that supports all processes involving direct customer contact throughout the entire customer relationship life cycle. ",
                "SAP ERP is an application that a company can use to manage its business processes efficiently. ",
                "SAP ERP is a system in which advanced planning and optimization processes can be mapped. ",
                "SAP ERP is a system hardware that includes components such as Purchasing, Sales and Distribution, Materials Management, and Production.\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e31);

        Question e32 = new Question("Which option for selecting a routing exists when you create a production order?\n",
                "Automatic selection of a reference operation set ",
                "Manual selection based on settings in the order type-dependent parameters ",
                "Automatic selection based on the selection ID in the material master",
                "Manual selection based on the list of routings maintained in the material master\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e32);

        Question e33 = new Question("Which of the following items of master data are needed for repetitive manufacturing?(Choose three)\n",
                "Production supply area ",
                "Repetitive manufacturing profile\n",
                "Production version ",
                "Master record for serial numbers ",
                "Product cost collector\n",
                null,
                null, "X", "X", null, "X", null, Question.C_TSCM42_66);
        addQuestion(e33);

        Question e34 = new Question("In SAP ECC, you calculate the standard available capacity for a work center capacity using the followingdata:\n" +
                "- Start: 7:00:00 a.m.\n" +
                "-End:3:00:00 p.m.\n" +
                "- Break duration: 1 hour\n" +
                "- Rate of utilization: 80%\n" +
                "-Overload:110%\n" +
                "- Number of individual capacities: 1\n" +
                "How large is the standard available capacity?\n",
                "8 hours ",
                "5.6 hours ",
                "6.16 hours ",
                "7 hours\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e34);

        Question e35 = new Question("An enterprise based in the US produces an end product that is used with the unit of measure \"pound\" (LB). The material is now to be marketed in the EU. A prerequisite for this is that the material can be sold with the unit \"kilogram\" (KG).\n" +
                "What is the easiest way to fulfill this requirement?\n",
                "Define a unit of measure group that converts pounds to kilograms in the basic data customizing and assign it to the material master on basic data view 1. ",
                "Add a conversion factor for converting pounds to kilograms on basic data view 1 in the material master. ",
                "Create a new material with a reference to the original material and assign the metric unit of measure to the new material master. ",
                "There is no need to take any action. In this scenario, the conversion of units of measurements is done automatically.\n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e35);

        Question e36 = new Question("What can you use to organize material staging for production orders?(Choose three)\n",
                "Material documents ",
                "Transfer orders ",
                "KANBAN",
                "Pull list ",
                "Logistics Information System (LIS)\n",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM42_66);
        addQuestion(e36);

        Question e37 = new Question("Which property applies for consumption with planning strategy 40 (planning with final assembly)?\n",
                "Consumption creates a static and binding assignment between the planned independent requirements and the customer requirements for the entire procurement process. ",
                "Consumption takes place with the planning material. ",
                "Consumption can reduce the total originally planned production quantity. ",
                "Consumption can increase the total originally planned production quantity.\n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e37);

        Question e38 = new Question("Which of the following elements can be used in a process order?(Choose three)\n",
                "Process instructions ",
                "Parallel sequences ",
                "Relationships",
                "Suboperations",
                "Phases",
                null,
                "X", null, "X", null, "X", null, Question.C_TSCM42_66);
        addQuestion(e38);

        Question e39 = new Question("You want to create a new material that - is kept in stock- is externally procured- is used as a component in the bills of material for various final products- must not be sold directly\n" +
                "Which standard SAP material type do you use?\n",
                "NLAG (non-stock material) ",
                "FERT (finished product) ",
                "ROH (raw material) ",
                "HAWA (trading good)\n",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e39);

        Question e40 = new Question("In which master data object do you set the standard values for an operation?\n",
                "Material Master ",
                "Work Center ",
                "Routing",
                "Production Resource/Tool (PRT)",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e40);

        Question e41 = new Question("What features related to process orders can be used to fulfill Good Manufacturing Practices (GMP) requirements?(Choose three)\n",
                "Approved master recipes ",
                "Digital signature ",
                "Electronic batch record ",
                "Availability check ",
                "Resource selection",
                null,
                "X", "X", "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e41);

        Question e42 = new Question("In the SAP ECC system, a material is produced using production orders. The planning table for repetitive manufacturing should be used to plan line loading for this material. On the initial screen of the planning table, you select this material and then receive a message informing you that you cannot use the planning table for this material.\n" +
                "What could be the reason?",
                "There are no planned orders or production orders present. ",
                "The repetitive manufacturing indicator has been set. ",
                "There is no valid production version for this material. ",
                "There are no requirements present.\n",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e42);

        Question e43 = new Question("Which activities lead to a reduction of the capacity requirements for an operation?(Choose three\n",
                "Rescheduling the operation ",
                "Posting the goods receipt for the production order ",
                "Confirming the operation ",
                "Setting the status technically complete (TECO) ",
                "Reducing the order quantity\n",
                null,
                null, null, "X", "X", "X", null, Question.C_TSCM42_66);
        addQuestion(e43);

        Question e44 = new Question("What are characteristics of repetitive manufacturing?(Choose three)\n",
                "Production without using production orders and without status management ",
                "Shop fabrication ",
                "Automatic line loading based on capacity limits across all production lines ",
                "Continuous material consumption, production flow and output",
                "Period-based planning of the quantities to be produced",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_66);
        addQuestion(e44);

        Question e45 = new Question("Which of the following organizational efforts can be minimized using the KANBAN procedure?\n",
                "Effort for material staging ",
                "Effort for capacity planning ",
                "Effort for Sales and Operations Planning (SOP) ",
                "Effort for master data maintenance\n",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e45);

        Question e46 = new Question("In which of the following objects can you activate backflushing for production\n" +
                "orders?(Choose three)\n",
                "Work center ",
                "Routing",
                "Material master (finished product) ",
                "Material master (component) ",
                "Production scheduling profile\n",
                null,
                "X", "X", null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e46);

        Question e47 = new Question("When maintaining a work center, formulas can be assigned in the scheduling view. Formulas use formula parameters for calculation.\n" +
                "What can be the origin of the formula parameters used for scheduling?(Choose three)\n",
                "User-defined fields in the operation of routings ",
                "General operation values of routings ",
                "General item values of bill of materials ",
                "General values from work scheduling view of the material master ",
                "Standard values in the operations of routings",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM42_66);
        addQuestion(e47);

        Question e48 = new Question("What functions can you use for suboperations?(Choose two)\n",
                "Costing",
                "Material component allocation ",
                "Production/Resource tools allocation ",
                "Capacity planning\n",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e48);

        Question e49 = new Question("Which of the following functions does SAP Supply Chain Management (SCM) offer?\n",
                "Product development, safety, quality, and maintenance ",
                "Planning of supply chains across company boundaries ",
                "Communication with customers through different interaction channels ",
                "Optimization of the procurement strategy with the supplier pool\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e49);

        Question e50 = new Question("Which of the following are characteristics of ECC master production scheduling (MPS)?(Choose three)\n",
                "MPS items are planned in a standard MRP run. ",
                "The planning of MPS and non-MPS items is always carried out in one planning run. ",
                "Non-MPS items can be taken into consideration by an MPS run. ",
                "MPS items can be defined on plant level. ",
                "MPS items can be defined on MRP area level.\n",
                null,
                null, null, "X", "X", "X", null, Question.C_TSCM42_66);
        addQuestion(e50);

        Question e52 = new Question("Where in the SAP ECC system can you define production versions?\n",
                "In the material master ",
                "In the routing ",
                "In the bill of material ",
                "In the work center\n",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e52);

        Question e53 = new Question("You want to reduce the uncertainty caused by fluctuating requirements for a finished product by using a dynamic safety stock in SAP ECC.\n" +
                "On which specifications is the dynamic safety stock calculation based?\n",
                "The static safety stock and the material forecast ",
                "The average daily demand and the safety time ",
                "The average daily demand and the desired range of coverage ",
                "The static safety stock per day and the safety time\n",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e53);

        Question e54 = new Question("What is a feature of the simu-lation mode for material requirements planning in SAP ECC?\n",
                "It calculates the delay time which may occur in planning. ",
                "It triggers multilevel bottom-up scheduling. ",
                "It propagates exception messages from a component to the finished product. ",
                "It posts planning results to the database automatically.\n",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e54);

        Question e55 = new Question("What do you have to consider when you use SAP ECC long-term planning (LTP)?(Choose two)\n",
                "A planning scenario must be released before it can be used in LTP. ",
                "Reorder point planned materials can be included in LTP. ",
                "LTP focuses on the operational planning of important components. ",
                "LTP creates purchase requisitions for external procurement.\n",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e55);

        Question e56 = new Question("You select the master data for production orders via production versions.\n" +
                "Which information is contained in a production version?\n",
                "The explosion dates for the routing and BOM ",
                "The routing and BOM alternatives to be used ",
                "The default order type to be used ",
                "The control parameters for selecting routings and BOM\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e56);

        Question e57 = new Question("Which of the following functions are available in SAP ECC when using capacity leveling?(Choose three)\n",
                "Batch size optimization ",
                "Midpoint scheduling ",
                "Lot size optimization ",
                "Finite capacity scheduling ",
                "Setup time reduction\n",
                null,
                null, "X", null, "X", "X", null, Question.C_TSCM42_66);
        addQuestion(e57);

        Question e58 = new Question("You have maintained planning strategy group 10 (make-to-stock production) in the material master (SAP ECC) of a material. For the coming months, you have planned requirements with requirement type LSF (derived from main strategy 10). Now, you want to change therequirement type from LSF to VSF (in accordance with planning strategy 40, planning with final assembly) for requirements in the existing production plan.\n" +
                "Which of the following scenarios are applicable in this case?(Choose two)\n",
                "You can enter the strategy group 40 in the material master, but the requirement type is not changed automatically for existing requirements. ",
                "You must change the requirement type for planning strategy 10 to VSF in Customizing. The requirement type for all existing requirements is then changed by the next planning run. ",
                "You can change the strategy group from 10 to 40 for the existing production plan in the material master, and the requirement type for all requirements is changed automatically. ",
                "You can enter the strategy group 40 in the material master and change the present requirement for the product manually in the production plan.\n",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e58);

        Question e59 = new Question("When modeling in-house production using SAP ECC, on which business levels can you create a bill of material (BOM)?(Choose two)\n",
                "At the company code level ",
                "At the plant level ",
                "At the business area level ",
                "At the client level\n",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e59);

        Question e60 = new Question("A material was planned in the context of SAP ECC material requirements planning. The MRP controller subsequently processed the material by manually converting a specific planned order into a production order. The MRP controller now accesses the current stock/requirements list and the MRP list for this material and compares these two lists.\n" +
                "What do you have to consider for the two lists at this stage?(Choose two)\n",
                "The stock/requirements list was updated the moment it was accessed. ",
                "The MRP list displays the production order. ",
                "The MRP list has the status \"processed\". ",
                "The stock/requirements list displays the production order.\n",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e60);

        Question e61 = new Question("Which function is supported by production orders?\n",
                "Automatic selection of a work center at order release ",
                "Automatic creation of transfer orders at order release ",
                "Automatic reading of PP master data at order release",
                "Automatic printing of order documents at order creation",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e61);

        Question e62 = new Question("Which of the following activities is necessary for the capacity availability check that can be carried out automatically when a production order is released?\n",
                "Set the finite scheduling indicator and assign a checking rule in the work center for the operation to be checked.\n",
                "Activate the availability check and assign an overall profile in the checking control of the order type / plant combination",
                "Assign an appropriate availability checking rule to the material master for the product. ",
                "Activate the availability check and assign an overall profile in the production scheduling profile.\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e62);

        Question e63 = new Question("Which Customizing element controls the determination of planned costs in production orders?\n",
                "Accounting type ",
                "Costing variant ",
                "Calculation procedure ",
                "Settlement profile\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e63);

        Question e64 = new Question("During the processing of production orders planned and actual costs are determined.\n" +
                "On which of the following objects can you collect these costs?(Choose two)\n",
                "Production order ",
                "Product cost collector ",
                "Work center ",
                "Planned order\n",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e64);

        Question e65 = new Question("The availability check during production order creation should use a different scope of check than during order release.\n" +
                "How can you fulfill this requirement?\n",
                "Maintain appropriate checking rules in checking control for order creation and order release. ",
                "Maintain appropriate availability checking rules in the order type-dependent parameters. ",
                "Maintain an appropriate availability checking group in the material master. ",
                "Maintain appropriate availability checking rules in the production scheduling profile.\n",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e65);

        Question e66 = new Question("What do you have to consider, when you use the ATP (Available To Promise) checks for material?(Choose two)\n",
                "ATP checks can be carried out automatically when releasing a production order. ",
                "ATP checks are automatically performed during Material Requirements Planning (MRP) runs. ",
                "ATP checks are used to evaluate the free capacity on a certain work center. ",
                "ATP checks are mandatory for lead-time scheduling. ",
                "ATP checks can be adjusted to also consider future requirements and receipts.\n",
                null,
                "X", null, null, null, "X", null, Question.C_TSCM42_66);
        addQuestion(e66);

        Question e67 = new Question("Your customer tests the firming options for planned orders in SAP ECC using a test material. Therefore, the customer sets a firming date in the stock/requirements list manually. Additionally, the customer sets a planning time fence with firming type 1 in the material master.\n" +
                "How is the resulting firming interval specified in this scenario?\n",
                "By the planning time fence from the material master ",
                "By the firming mechanism with the longer firming interval ",
                "By the manual firming date ",
                "It is predefined in Customizing.\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e67);

        Question e68 = new Question("In what sequence are the steps of material requirements planning performed in SAP ECC?\n",
                "1. Net requirements calculation 2. Lot sizing 3. Determination of the procurement type 4. Scheduling ",
                "1. Calculation of safety stock 2. Lot sizing 3. Scheduling 4. Determination of the procurement type ",
                "1. Availability check 2. Lot sizing 3. Determination of the procurement type 4. Scheduling ",
                "1. Net requirements calculation 2. Lot sizing 3. Scheduling 4. Determination of the procurement type\n",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e68);

        Question e69 = new Question("Which of the following master data is necessary for the creation of material reservations for production orders?\n",
                "Material master records ",
                "Production/resource tools",
                "Routings",
                "Production versions\n",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e69);

        Question e70 = new Question("What do you have to consider regarding lot size procedures?\n",
                "The procurement quantity of a lot size procedure can be specified using a safety time period profile. ",
                "If a long-term lot size is used, procurement is conducted with a long-term perspective. ",
                "The lot size quantity can be influenced using a minimum lot size and the rounding profile. ",
                "If a make-to-order production strategy is used, only the lot-for-lot (exact) lot size can be applied.\n",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e70);

        Question e71 = new Question("What sequence do you follow in master data maintenance to define the production of a material?\n",
                "Create work centers -> Create routing -> Create BOM -> Carry out component assignment in work center ",
                "Create routing -> Create work centers -> Create BOM -> Carry out component assignment in BOM or routing ",
                "Create BOM -> Create work centers -> Create routing -> Carry out component assignment in work center ",
                "Create BOM -> Create work centers -> Create routing -> Carry out component assignment in BOM or routing\n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e71);

        Question e72 = new Question("Your customer does not want to manage value-intensive materials in the warehouse. These materials should be procured directly for the production order.\n" +
                "Which BOM item category must you set to fulfill this requirement?\n",
                "D (document item) ",
                "E (external procurement) ",
                "M (phantom material) ",
                "N (non-stock item)\n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e72);

        Question e73 = new Question("Which of the following requirements is supported by using process orders?\n",
                "Linkage of documents to orders ",
                "Use of production/resource tools ",
                "Documentation of the production using an electronic batch record ",
                "Use of reference operation sets\n",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e73);

        Question e74 = new Question("An enterprise wants to use SAP ECC requirements planning together with the NETPL procedure (net change planning in the planning horizon). The planning horizon should be set equally for all materials by default. However, some materials need to have a different planning horizon.\n" +
                "Which procedure do you recommend for setting the planning horizon?\n",
                "Set the planning horizon in the MRP groups in Customizing and store deviant entries in the material masters for the corresponding materials. ",
                "Set the planning horizon in the plant parameters in Customizing and store deviant entries in the material masters for corresponding materials. ",
                "Set the planning horizon in the MRP groups and assign deviant entries via the plant parameter settings in Customizing. ",
                "Set the planning horizon in the plant parameters in Customizing and assign deviant entries via the MRP groups for the corresponding materials.\n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e74);

        Question e75 = new Question("Which repetitive manufacturing options can you use to carry out line loading in the SAP ECC system, and thus generate run schedule quantities (RSQ) from normal planned\n" +
                "orders?(Choose three)\n",
                "Automatic selection of the production line assigned to the MRP group used during material requirements planning (MRP) ",
                "Automatic selection of the production version in material requirements planning (MRP) using the selection methods setting ",
                "Automatic selection of the production version by applying quota arrangement records in material requirements planning (MRP) ",
                "A planning algorithm from capacity planning ",
                "Manual assignment of planned production quantities in a planning table\n",
                null,
                null, "X", "X", null, "X", null, Question.C_TSCM42_66);
        addQuestion(e75);

        Question e76 = new Question("Where can you define the valid receivers for production order costs?\n",
                "In the costing variant ",
                "In the settlement profile ",
                "In the valuation variant ",
                "In the production scheduling profile\n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_66);
        addQuestion(e76);

        Question e77 = new Question("What do you have to consider regarding consumption?(Choose two)\n",
                "Consumption takes place on the material level between the planned independent requirements and the planned orders. ",
                "Consumption is restructured with the planning run",
                "Consumption can take place between order reservations and planned independent requirements, depending on the strategy. ",
                "Consumption parameters (consumption mode and consumption interval) can be set in the material master or in the MRP group.\n",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM42_66);
        addQuestion(e77);

        Question e78 = new Question("What data can be posted directly via the Plant Data Collection (PP-PDC) interface?\n",
                "Goods receipts ",
                "Maintenance notifications ",
                "Confirmations",
                "Goods issues\n",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_66);
        addQuestion(e78);

        Question e79 = new Question("You use a planning time fence and fixing type 1. You receive a customer order with a material availability date within the planning time fence.\n" +
                "What do you have to consider in this scenario?\n",
                "Requirements planning considers only changes that are relevant for scheduling within the planning time fence. ",
                "Planned orders are created within the planning time fence and automatically firmed by requirements planning. ",
                "The MRP controller cannot create planned orders within the planning time fence. ",
                "Planned orders that are created by requirements planning are shifted to the end of the planning time fence.\n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e79);

        Question e80 = new Question("What are the names of the objects for process integration of production orders?(Choose two)\n",
                "Control recipes ",
                "Work instructions ",
                "PI sheets ",
                "Control instructions\n",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM42_66);
        addQuestion(e80);

        Question f1 = new Question("In SAP ECC, you want to map an in-house production process for general warehouse production. The fields in the area of the lot size-dependent in-house production time are to be populated when the material master for the final product is created. These fields can be maintained by updating from the scheduling result for the associated routing. You now think that there could be significant changes to the production times in the routing and decide against updating the material master. What problem could this lead to? ",
                "Subsequent capacity planning is no longer possible due to the obsolete scheduling parameters. ",
                "Requirements planning runs up against an exception message in basic dates scheduling because  the material master parameters do not match the scheduling result from the routing. ",
                "In the course of basic dates scheduling with requirements planning, dependent requirements request  the components from the bill of materials at the wrong times. ",
                "Lead time scheduling, which occurs by the time that a planned order is converted into a production  order (at the latest), cannot take place on the basis of incorrect basic dates. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f1);

        Question f2 = new Question("Which of the following requirements for a manufacturing plant can be supported by using process manufacturing? (Choose three.) ",
                "Master recipe-based manufacturing. ",
                "Material requirements planning for production resources. ",
                "Manufacturing without orders. ",
                "Variable calculation of material quantities (product output, material usage). ",
                "Manufacturing in charge quantities. ",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f2);

        Question f3 = new Question("Which objects can you use in the production order for a material component to propose the storage location in its reservation? (Choose three.) ",
                "Routing ",
                "Work center",
                "Material master (component) ",
                "Material master (product) ",
                "Production version ",
                null,
                null, "X", "X", null, "X", null, Question.C_TSCM42_65);
        addQuestion(f3);

        Question f4 = new Question("From what point can you no longer use the Read PP master data in the production order? ",
                "After printing the order papers",
                "After the first posting of goods movements or confirmation. ",
                "From the release of the production order. ",
                "After assigning the confirmed quantity of a material component due to carrying out a material  availability check. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f4);

        Question f5 = new Question("Which options can you offer someone who uses the SAP ECC system for production orders and requires support for material supply in production? (Choose three.) ",
                "Automatic generation of a transport order ",
                "Material directory ",
                "Pull list ",
                "Pick list ",
                "Logistics Information System (LIS) ",
                null,
                "X", null, "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f5);

        Question f6 = new Question("When maintaining a work center, formulas can be assigned in the scheduling view. Formulas use formula parameters for calculation. What can be the origin of the formula parameters used for scheduling? (Choose three.) ",
                "General values from work scheduling view in the material master ",
                "Standard value from operation in task list ",
                "User-defined field from operation in task list ",
                "General operation values in task list ",
                "General item values in bill of materials ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f6);

        Question f7 = new Question("A user has entered planning strategy group 10 (make-to-stock production) in the material master (SAP ECC) of a product. For the coming months, requirements with requirement type LSF (derived from the main strategy 10) have been planned. The user would like to change the requirement type from LSF to VSF planning with final assembly (in accordance with planning strategy 40) for requirements in the production plan that have already been saved. Which of the following statements are applicable in this case? (Choose two.)",
                "The user has to change the requirement type for planning strategy 10 to VSF planning with final  assembly in Customizing. The requirement type for all existing requirements is then changed  automatically. ",
                "The present requirement for the product can be changed manually from LSF to VSF in the  Requirement Type field in the production plan, so that the new strategy 40 determines the next  planning operation. ",
                "The user can enter the new planning strategy group 40 in the material master of the product,  but the requirement type is not changed automatically for existing requirements. ",
                "The planning strategy group can be changed from 10 to 40 in the existing production plan, and  the requirement type for all requirements is changed automatically.",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f7);

        Question f8 = new Question("Which of the following statements about the planning functions available in SAP ECC are true? (Choose two.) ",
                "Master production scheduling (MPS) refers to preferred planning of important materials. ",
                "Material requirements planning (MRP) does not include automatic capacity leveling. ",
                "Long-term planning (LTP) is a long-term form of forecast planning. ",
                "In demand management (DM) material shortage situations are identified and given requirement  coverage elements. ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f8);

        Question f9 = new Question("Which data forms the basis for calculating the capacity requirement for an operation? (Choose three.) ",
                "Standard values (routing) ",
                "In-house production time (material master) ",
                "Transport time (routing) ",
                "Formulas (work center) ",
                "Operation control key (routing) ",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f9);

        Question f10 = new Question("A user you advise wishes to transfer variable process instructions for automated processing directly to certain work centers and machines in the production department (for example, feed speed, pressing pressure, dry temperature). The user also wishes to receive variable as-is messages (such as actual quantities, actual times) from these work centers and machines and to process these messages for feedback concerning production orders. Which of the following options would you recommend to implement these requirements?",
                "Execution Steps (XSteps) and process messages ",
                "SAP Business Intelligence (BI) ",
                "Plant data collection (PP-PDC) interface ",
                "SAP Application Link Enabling (ALE) ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f10);

        Question f11 = new Question("In SAP ECC, you calculate the standard available capacity for a work center capacity with the following data: start: 7:00:00 a.m., end. 3:00:00 p.m., break duration: 1 hour, rate of utilization: 80%, overload. 110%, number of individual capacities: 1. How large is the standard available capacity? \n" +
                " ",
                "7 hours ",
                "8 hours",
                "5.6 hours ",
                "6.16 hours ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f11);

        Question f12 = new Question("A finished material is to be planned in a controlled manner in the SAP ECC system in the context of requirements planning. The planned orders are scheduled using what is known as basic date scheduling (not lead-time scheduling). Which of the following statements is true for the resulting dependent requirements?",
                "When a customer order is created for the finished product, the dependent requirements are  automatically triggered for the components in the bill of material without a planning run. ",
                "In multi-level backward scheduling, dependent requirements are triggered at the start date for  the higher-level assembly. ",
                "In multi-level backward scheduling, dependent requirements are triggered at the start date for  the higher-level assembly planned order. ",
                "If individual material components are explicitly assigned to operations during BOM and routing  maintenance, the requirement dates of the dependent requirements for these components are  scheduled at each of the operation start dates. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f12);

        Question f13 = new Question("Which of the following master data do you need to make available for repetitive manufacturing? (Choose three.) ",
                "Master records for serial numbers ",
                "Repetitive manufacturing profile ",
                "Production supply area ",
                "Production versions ",
                "Product cost collector ",
                null,
                null, "X", null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f13);

        Question f14 = new Question("Which of the following structural elements does a process order have? (Choose three.) ",
                "Item data ",
                "Parallel sequences ",
                "Relationships ",
                "Phases ",
                "Characteristic-based process instructions ",
                null,
                null, null, "X", "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f14);

        Question f15 = new Question("Which of the following situations occur when a production order is set to Technically Complete (TECO)? (Choose three.) ",
                "The order and its operations receive the system status Locked (LKD). ",
                "Reservations are deleted. ",
                "Purchase orders for external operations or non-stock materials are deleted. ",
                "The order is no longer relevant for Material Requirements Planning. ",
                "Capacity requirements are deleted. ",
                null,
                null, "X", null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f15);

        Question f16 = new Question("The master data for an in-house production process is to be set up in the SAP ECC system. To do this, you should create a suitable routing that plans for five operations in an initial sequence (10, 20, 30, 40, 50). There should be an option of relocating operations 30 and 40 to a second sequence on other work centers if there are capacity bottlenecks. What sequence type would you use to create the second sequence in the system? ",
                "Substitute sequence ",
                "Alternative sequence ",
                "Parallel sequence ",
                "Standard sequence ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f16);

        Question f17 = new Question("Which of the following are properties of ECC Multi-Site Planning? (Choose two.) ",
                "Both withdrawal from alternative plant and withdrawal from another plant are defined via special  procurement keys. ",
                "The use of scope of planning (cross-plant total planning) is mandatory for Multi-Site Planning. ",
                "When using one-step stock transfer posting, transfer stock is created in the receiving plant. ",
                "When using two-step stock transport order with delivery, the receiving plant is defined as a customer. ",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f17);

        Question f18 = new Question("What does SAP ERP mean? ",
                "SAP ERP is a system hardware that includes modules for purchasing, sales and distribution,  materials management, production and so on. ",
                "SAP ERP is a technological platform on the basis of which customer-specific extensions can be  imported. ",
                "SAP ERP is an application that an enterprise can use to manage its business processes efficiently. ",
                "SAP ERP is a planning system in which extended planning processes can be mapped. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f18);

        Question f19 = new Question("A final assembly process takes place at three work centers, one after the other. The routing, which consists of three associated operations (10, 20 and 30), plans for a specific BOM component to be installed during operation 30 and not before. The component should therefore only be requested at the start of operation 30. What sequence do you follow in master data maintenance in SAP ECC to make this component available in line with operations during final assembly? ",
                "1. Create BOM 2. Create work centers 3. Create routing 4. Carry out component assignment  in BOM or routing ",
                "1. Create work centers 2. Create routing 3. Create BOM 4. Carry out component assignment  in work center ",
                "1. Create routing 2. Create work centers 3. Create BOM 4. Carry out component assignment in  BOM or routing",
                "1. Create BOM 2. Create work centers 3. Create routing 4. Carry out component assignment in  work center ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f19);

        Question f20 = new Question("In the task list, there is the possibility to work with suboperations. What can you do in more detail by using suboperations? (Choose two.) ",
                "Material component allocation ",
                "Costing ",
                "Capacity planning ",
                "Scheduling ",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f20);

        Question f21 = new Question("Which of the following statements about ATP (Available To Promise) checks for material components are correct? (Choose two.) ",
                "ATP checks are automatically performed during MRP (Material Requirements Planning) runs. ",
                "ATP checks can be adjusted to also consider future requirements and receipts. ",
                "ATP checks are used to evaluate the free capacity on a certain work center. ",
                "ATP checks can be carried out automatically when releasing a production order. ",
                "ATP checks are mandatory for lead-time scheduling. ",
                null,
                null, "X", null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f21);

        Question f22 = new Question("Which options can you offer a user of the SAP ECC system for managing costs (costing and settlement) with regards to production orders? (Choose two.) ",
                "Series-based costing",
                "Work center-based costing ",
                "Order-based costing ",
                "Product cost collecting ",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f22);

        Question f23 = new Question("Which of the following master data is mandatory for production order processing, when material reservations and capacity requirements for operations should be generated automatically? (Choose two.) ",
                "Routing ",
                "Inspection characteristics ",
                "Document structure ",
                "Production versions ",
                "Material master records (product and material component) ",
                null,
                "X", null, null, null, "X", null, Question.C_TSCM42_65);
        addQuestion(f23);

        Question f24 = new Question("Which of the following functions occur when a production order is created? (Choose three.) ",
                "Copying a document that is assigned to the material master for the product to be produced ",
                "Calculating the lead time for the production order ",
                "Selecting and copying a bill of material ",
                "Selecting and copying a routing ",
                "Calculating the quantity to be produced on the basis of the available material stocks ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f24);

        Question f25 = new Question("Which of the following master data do you always have to make available for material replenishment using the KANBAN procedure? (Choose two.) ",
                "Control cycles ",
                "Production supply areas",
                "Product cost collector",
                "Rate routings ",
                "Production versions ",
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f25);

        Question f26 = new Question("A material was planned in the context of SAP ECC material requirements planning and the MRP controller subsequently processed the material by manually converting a specific planned order into a production order. The MRP controller now accesses the current stock/requirements list and the MRP list for this material and compares the two. Which of the following statements are true for the two lists at this stage? (Choose two.) ",
                "The MRP list has the status \"processed\". ",
                "The MRP list displays the production order. ",
                "The stock/requirements list was updated at the precise time it was accessed. ",
                "The stock/requirements list displays the production order. ",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f26);

        Question f27 = new Question("Which information is contained in production versions for selecting routings and bills of material? ",
                "The plant for which the routing and BOM have to be created ",
                "All the control parameters for selecting routings and bills of material ",
                "The routing and BOM alternatives to be used for production ",
                "The explosion date on which the validity of the routing and bill of material is checked ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f27);

        Question f28 = new Question("A new material with the following properties is to be recorded in SAP ECC. the material is kept in stock, is externally procured, and is used as a component in the bills of material for various final products. However, this material may not be purchased directly. Which standard SAP material type would you use?",
                "HAWA (trading good) ",
                "FERT (finished product) ",
                "NLAG (non-stock material)",
                "ROH (raw material) ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f28);

        Question f29 = new Question("In the Customizing for requirements planning, a project team notices that the alternatives P1, P2, P3 and P4 are also delivered as standard in addition to MRP type PD. The number in each of these alternatives represents a firming type. What does a firming type define? (Choose two.) ",
                "Handling existing procurement proposals within a planning time fence. ",
                "Handling new procurement proposals that are to be created due to new requirements within the  planning time fence. ",
                "Handling existing procurement proposals outside the planning time fence. ",
                "Handling new requirements within the planning time fence. \n",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f29);

        Question f30 = new Question("A customer has been using planning strategies 30 (production by lots) and 10 (anonymous make-to- stock production) in SAP ECC. The customer wishes to move in part to planning strategy 40 (planning with final assembly). The issue of consumption has an effect here for the first time. Which properties apply for consumption with planning strategy 40? (Choose two.) ",
                "Consumption can lead to an increase of the originally planned overall production quantity. ",
                "Consumption can result in the subsequent specification and adjustment of planning elements  in terms of quantity and date, by means of customer orders that arrive. ",
                "Consumption can reduce the originally planned production quantity. ",
                "Consumption creates a static and binding assignment, between the planned independent requirements recorded in advance and the customer requirements that arrive, for the entire procurement process. ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f30);

        Question f31 = new Question("Which of the following aspects characterize repetitive manufacturing in a manufacturing plant? (Choose three.) ",
                "Period-based planning of the quantities to be produced ",
                "Automatic line loading by capacity limits across all production lines ",
                "Continuous material consumption, production flow and output ",
                "Production without using production orders and without status management ",
                "Shop fabrication ",
                null,
                "X", null, "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f31);

        Question f32 = new Question("What options for selecting a routing exist when creating a production order? (Choose three.) ",
                "Automatic selection, controlled via settings in Customizing ",
                "Manual selection ",
                "Selection on the basis of the routing number in the material master for the material to be produced ",
                "Selection on the basis of the production control profile ",
                null,
                null,
                "X", "X", null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f32);

        Question f33 = new Question("The Service Desk is available as part of the SAP Solution Manager. Which functions are included in the scope of the Service Desk? (Choose two.) ",
                "SAP Help ",
                "Managing SAP Notes ",
                "Process for processing messages ",
                "Troubleshooting ",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f33);

        Question f34 = new Question("Which of the following prerequisites have to be fulfilled for production orders to be transferred to a business data entry system via the Plant data collection (PP-PDC) interface? (Choose three.) ",
                "Execution Steps were used to record process instructions in the operation.",
                "The application of the PP-PDC interface was activated in the order type for the production order. ",
                "Production orders contain at least one operation that contains a work center with a subsystem group  assigned to it. ",
                "The material to be produced with a production order was flagged for transfer in its material master. ",
                "Production orders have been released. ",
                null,
                null, "X", "X", null, "X", null, Question.C_TSCM42_65);
        addQuestion(f34);

        Question f35 = new Question("In modeling in-house production using SAP ECC, bills of material (BOM) are to be recorded in the system. On which business levels can you create a BOM? (Choose two.) ",
                "At the company code level ",
                "At the business area level ",
                "At the plant level ",
                "At the client level ",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f35);

        Question f36 = new Question("The master data for a logistical process is to be stored in the SAP ECC system. In this context, you require the production versions for subsequent planning and production. You know a mass maintenance transaction that you could use here. Where else in the SAP ECC system could you define production versions? ",
                "In the material master. ",
                "In the work center. ",
                "In the repetitive manufacturing profile in Customizing. ",
                "In the line routing. ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f36);

        Question f37 = new Question("For a specific end product, you want to use a planning time fence and fixing type 1 to ensure that the planning situation in SAP ECC calms down in a short-term time window. Two customer orders arrive at short notice and their receipts should really be within the planning time fence, due to their date/time. Which statement is true with this scenario? ",
                "Within the planning time fence, the newly created planned orders are automatically frozen by  requirements planning (roll forward). ",
                "Newly created planned orders cannot be created by requirements planning before the end of  the planning time fence, at the earliest. ",
                "The MRP controller has no possibility of creating planned orders within the planning time fence. ",
                "Requirements planning only examines changes that are relevant to scheduling within the planning  time fence; the customer orders are covered in time.",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f37);

        Question f38 = new Question("What are the consequences of a confirmation of an operation? (Choose two.) ",
                "Actual costs are posted for the production confirmed. ",
                "The produced and confirmed quantity is automatically posted to the warehouse stock as a receipt. ",
                "Serial numbers are assigned for the confirmed quantity. ",
                "The operation's capacity requirements are reduced. \n",
                null,
                null,
                "X", null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f38);

        Question f39 = new Question("Which of the following possible errors would lead to the message shown? (Choose two.) \n" +
                " ",
                "In the material master, plan selection was set to production version. A production version was  created and it is faulty. ",
                "There are no valid routings or no routings available on the explosion date. ",
                "The Customizing for the order type is set to manual routing selection and a valid routing exists. ",
                "The material master (product) is set to manual routing selection and valid routing exists. ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f39);

        Question f40 = new Question("In the course of a project phase, the customer raises some questions concerning parameters of the procurement type in the material master in the SAP ECC system. Which of the following procurement type properties apply? (Choose two.) ",
                "A material's procurement type can always be freely selected between E (in-house production), F  (external procurement) and X (both procurement types). ",
                "If procurement type E (in-house production) is set, external procurement may still be permissible. ",
                "If both procurement types are allowed with entry X, requirements planning assumes in-house production. ",
                "Procurement types E (in-house production) and F (external procurement) have to be further refined with special procurement types. ",
                null,
                null,
                null, "X", "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f40);

        Question f41 = new Question("Which properties does ECC Master Production Scheduling (MPS) have? (Choose three.) ",
                "MPS items can be taken into consideration by a standard MRP run (Material Requirements Planning). ",
                "MPS items can be defined on MRP Area level (Material Requirements Planning Area). ",
                "Non-MPS items can be taken into consideration by an MPS run. ",
                "MPS items can be defined on plant level. ",
                "The planning of MPS and Non-MPS items is always carried out in one planning run. ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f41);

        Question f42 = new Question("A customer wishes to only produce a finished product when customer orders for it are present. Final assembly should then be carried out at short notice in make-to-order production. Up until this point, the important assemblies needed in final assembly should already be available in stock. Provision of these assemblies should therefore be triggered by planning. Which options could you offer the customer as useful alternatives in SAP ECC? (Choose two.) ",
                "The finished product uses strategy 40 (planning with final assembly) and all the important assemblies  in the bill of material for the finished product should have strategy 70 (planning at the assembly level). ",
                "The finished product uses strategy 30 (production by lots) and all the important assemblies in the  bill of material for the finished product should have strategy 70 (planning at the assembly level). ",
                "The finished product uses strategy 20 (make-to-order production) and all the important assemblies  in the bill of material for the finished product should have strategy 70 (planning at the assembly level). ",
                "The finished product uses strategy 50 (planning without final assembly) and all the assemblies in the  bill of material for the finished product have no strategy.",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f42);

        Question f43 = new Question("Which one of the following scheduling types cannot be assigned as default to an order type (production order)? ",
                "Midpoint",
                "Forward ",
                "Only capacity requirements ",
                "Backward ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f43);

        Question f44 = new Question("In your enterprise, a planning strategy is used in SAP ECC that enables joint planning of all MRP scheduled assemblies for a finished product to trigger procurement of these assemblies. It is important to ensure that the finished product is only produced when there is a customer order present. When a customer order is received, production of the finished product should be triggered in the form of make-to-order planning and production. Which planning strategy covers this scenario? ",
                "Planning with make-to-stock (strategy 10)",
                "Planning at the assembly level (strategy 70) ",
                "Planning with final assembly (strategy 40) ",
                "Planning without final assembly (strategy 50) ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f44);

        Question f45 = new Question("An enterprise based in the USA produces an end product that is used with the unit of measure \"pound\" (LB). The material is now to be marketed in the EU. A prerequisite for this is that the material can be sold with the unit kilogram (KG). Which of the following solutions does SAP ECC offer? ",
                "In the basic data customizing, you create a unit of measure group that converts pounds to kilograms.  You then assign this to the material master on basic data view 1. ",
                "You create a new material with a reference to the original material and assign the metric unit of measure  to the new material master. ",
                "In the material master, you create a conversion factor for converting pounds to kilograms on basic data  view 1. ",
                "There is no need to take any action. There is a general conversion in the central customizing of units  of measurements, so that automatic conversion of pounds to kilograms takes place. ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f45);

        Question f46 = new Question("Which of the following functions are available in the SAP ECC system for leveling overloads in individual work centers with the capacity planning tools? (Choose three.) ",
                "Midpoint scheduling ",
                "Batch size optimization ",
                "Lot size optimization ",
                "Setup time reduction ",
                "Finite capacity scheduling ",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f46);

        Question f47 = new Question("The company that you advise does not want to manage certain value-intensive materials in the warehouse stock. Instead, the user wishes to control material provision in such a way that these materials are procured directly for the production and/or process order. How can you fulfill this request? (Choose two.) ",
                "Using the special procurement key subcontracting in the material master for the component ",
                "Using the special procurement key direct procurement/external procurement in the material master for  the component ",
                "Using the item type non-stock item in the bill of material for the material in question",
                "Using the procurement type external procurement in the material master for the component ",
                "Controlling the material in Question es a co-product",
                null,
                null, "X", "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f47);

        Question f48 = new Question("In SAP ECC, a customer tests the firming options for planned orders. The customer first sets the manual firming date from the stock/requirements list to firm planned orders that shall occur in the short term. In the material master, a rolling planning time horizon with firming type 1 is active. Some planned orders have also been firmed manually already. Which statement applies for the resultant firming situation? ",
                "The firming interval is specified by the manual firming date because it always overrides the planning time fence from the material master; all the manually firmed planned orders are firmed independently of this. ",
                "The firming interval is specified by the firming mechanism that currently stretches further into the future  and which firms planned orders that are within it; all the manually firmed planned orders are firmed independently of this.",
                "The firming interval is specified by the firming mechanism that currently stretches further into the future;  all the planned orders within this horizon are firmed only if they were previously firmed manually. ",
                "The firming interval is specified by the planning time fence from the material master, because this always overrides the manual firming date; all the manually firmed planned orders are firmed independently of this. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f48);

        Question f49 = new Question("Which of the following requirements for a manufacturing plant can be supported by using production orders? (Choose three.) ",
                "Variable calculation of material quantities (production output, material usage) and operation quantities. ",
                "Integrated display of documents (drawings, texts) in the production process.",
                "Make-to-stock production. ",
                "Orderless production. ",
                "Customer requirements-dependent production",
                null,
                null, "X", "X", null, "X", null, Question.C_TSCM42_65);
        addQuestion(f49);

        Question f50 = new Question("The user you advise requests that you make it possible for the user to produce materials for stock, for customer orders, projects, orders and cost centers with production orders. Where can you make settings to ensure these options? ",
                "Serial number profile. ",
                "Settlement profile. ",
                "Valuation variant. ",
                "Production scheduling profile. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f50);

        Question f51 = new Question("Which statement regarding lot size procedures is correct? ",
                "The procurement quantity of a lot size procedure can be specified using a safety time period profile. ",
                "If a long-term lot size is in use, procurement is conducted with a long-term perspective. ",
                "If a make-to-order production strategy is in use, a lot for lot (exact) lot size is always determined for  the corresponding procurement element. ",
                "The lot size quantity can be influenced using a minimum quantity and the rounding profile. \n",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f51);

        Question f52 = new Question("Where are the standard operation times for an operation defined? ",
                "Work Center ",
                "Material Master ",
                "Routing ",
                "Production Resource/Tool (PRT) ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f52);

        Question f53 = new Question("An enterprise wants to absorb the uncertainty caused by fluctuating demand for a finished product by means of a buffer variable in SAP ECC. They suggest a dynamic safety stock. What specifications are used to calculate the dynamic safety stock? ",
                "The average daily demand and the desired days supply ",
                "The average daily demand and the safety time ",
                "The static safety stock per day and the safety time ",
                "The static safety stock and a material forecast ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f53);

        Question f54 = new Question("The company you advise wants to carry out the material availability check automatically in the production order at various points in time. Which of the following options would you recommend? (Choose two.) ",
                "Goods receipt for the product produced with the order ",
                "Creation of the production order ",
                "Confirmation of the operation that the materials being checked are assigned to ",
                "Release of the production order ",
                "Goods receipt for a missing part ",
                null,
                null, "X", null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f54);

        Question f55 = new Question("What repetitive manufacturing options can you use to carry out line loading in the SAP ECC system and thus generate Run Schedule Quantities (RSQ) from normal planned orders? (Choose three.) ",
                "Automatic selection of the production version in material requirements planning (MRP) using Selection Methods setting. ",
                "Manual assignment of planned production quantities in a planning table. ",
                "Automatic selection of the production version by applying quota arrangement records in material requirements planning (MRP). ",
                "Using a planning algorithm from capacity planning. ",
                "Selecting a suitable repetitive manufacturing profile that contains an option for automatic line selection. ",
                null,
                "X", "X", "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f55);

        Question f56 = new Question("Which data forms the basis for calculating the capacity requirement for an operation? (Choose three.) ",
                "Standard values (routing) ",
                "In-house production time (material master) ",
                "Transport time (routing) ",
                "Formulas (work center) ",
                "Operation control key (routing) ",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f56);

        Question f57 = new Question("Which of the following activities within the KANBAN procedure normally triggers subsequent stock posting of the goods receipt? ",
                "Set Container in transport ",
                "Set Container in process ",
                "Set Container empty ",
                "Set Container full ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f57);

        Question f58 = new Question("Which of the following elements do you have to prepare for costing of a production order to function without errors? (Choose three.)",
                "Assign costing variants to order type",
                "Propose a standard text key in work center. ",
                "Assign a production scheduling profile to the material master (product). ",
                "Enter formulas for costing in the work center.",
                "Use an operation control key with the indicator costing-relevant. \n",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f58);

        Question f59 = new Question("In which of the following objects can you activate backflushing of components if you want to use this functionality during order confirmation? (Choose three.) ",
                "Work Center ",
                "Production Scheduling Profile ",
                "Material Master (Finished Product) ",
                "Routing",
                "Material Master (Component) \n",
                null,
                "X", null, null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f59);

        Question f60 = new Question("Which of the following master data do you need to provide for process manufacturing? (Choose three.) ",
                "Resources ",
                "Master recipe ",
                "Serial numbers ",
                "Product cost collector ",
                "Production versions ",
                null,
                "X", "X", null, null, "X", null, Question.C_TSCM42_65);
        addQuestion(f60);

        Question f61 = new Question("In your company planning strategies are used in the SAP-ECC demand management that is based on consumption. Which of the following statements about consumption is true? (Choose two.) ",
                "A consumption situation is dynamic and is always restructured with the planning run. ",
                "Consumption can also take place between order reservations and planned independent requirements, depending on the strategy. ",
                "Consumption always takes place on the material level between the planned independent requirements  and the planned orders. ",
                "The consumption parameters (consumption mode and consumption interval) can be set in the material  master or in the MRP group. ",
                null,
                null,
                null, "X", null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f61);

        Question f62 = new Question("In production order processing, for which of the following objects can you enter a confirmation? (Choose three.) ",
                "Work Center ",
                "Individual Capacity ",
                "Order ",
                "Operation / Suboperation ",
                "Trigger Point ",
                null,
                null, "X", "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f62);

        Question f63 = new Question("Which types of objects can be changed with Engineering Change Management? (Choose three.) ",
                "Bill of Materials ",
                "Work Center ",
                "Task List ",
                "Production Version ",
                "Material Master ",
                null,
                "X", null, "X", null, "X", null, Question.C_TSCM42_65);
        addQuestion(f63);

        Question f64 = new Question("When analyzing the SAP ECC order report for a planned order for a finished product, you discover that one of the assemblies will not be available in time for the scheduled final assembly because of automatic forward scheduling. Which planning procedure would you use to process the problem in order to create a solution that is feasible from a requirements planning perspective? ",
                "Multi-level single-item planning with the simulation mode option ",
                "Multi-level single-item planning with the display results before saving option ",
                "Interactive single-item planning for the delayed assembly ",
                "Total planning online ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f64);

        Question f65 = new Question("Which of the following statements about the SAP Solution Manager listed is correct? ",
                "Solution Manager is part of the SAP ECC System",
                "Solution Manager is an add-on industry solution. ",
                "Solution Manager is a stand-alone system that communicates with other systems in a system landscape. ",
                "Solution Manager is a satellite system in a system landscape. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f65);

        Question f66 = new Question("In the Customizing for requirements planning, a project team notices that the alternatives P1, P2, P3 and P4 are also delivered as standard in addition to MRP type PD. The number in each of these alternatives represents a firming type. What does a firming type define? (Choose two.) ",
                "Handling existing procurement proposals within a planning time fence. ",
                "Handling new procurement proposals that are to be created due to new requirements within the  planning time fence. ",
                "Handling existing procurement proposals outside the planning time fence. ",
                "Handling new requirements within the planning time fence. ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f66);

        Question f67 = new Question("In what order are the individual steps of material requirements planning performed in SAP ECC? ",
                "1. Net requirements calculation  2. Application of the lot-sizing procedure  3. Scheduling  4.Determination of the procurement type ",
                "1. Availability check  2. Application of the lot-sizing procedure  3. Determination of the procurement  type 4. Scheduling ",
                "1. Calculation of safety stock  2. Application of the lot-sizing procedure  3. Scheduling  4.Determination of the procurement type ",
                "1. Net requirements calculation  2. Application of the lot-sizing procedure  3. Determination of the  procurement type  4. Scheduling ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f67);

        Question f68 = new Question("Which of the following master data is mandatory for production order processing, when material reservations and capacity requirements for operations should be generated automatically? (Choose two.) ",
                "Routing ",
                "Inspection characteristics ",
                "Document structure ",
                "Production versions ",
                "Material master records (product and material component) ",
                null,
                "X", null, null, null, "X", null, Question.C_TSCM42_65);
        addQuestion(f68);

        Question f69 = new Question("In the course of a customer project, you are confronted with an SAP ECC system that shows the error message displayed below when you test requirements planning in plant 1000. Large numbers of materials are already available in plant 1000. As a first step in solving the problem, you activate requirements planning in the Customizing for plant 1000. What further steps must you take before you can put requirements planning in plant 1000 into operation in SAP ECC? ",
                "- Implement the planning files in Customizing - Specify the plant parameters for plant 1000 in  Customizing ",
                "- Activate requirements planning in Customizing for MRP areas in plant 1000 - Specify the plant  parameters for plant 1000 in the requirement planning views ",
                "- Implement the planning files in Customizing - Specify the plant parameters for plant 1000 in the  equirement planning views ",
                "- Create a planning file in Customizing - Specify the plant parameters for plant 1000 in Customizing ",
                null,
                null,
                null, null, null, "X", null, null, Question.C_TSCM42_65);
        addQuestion(f69);

        Question f70 = new Question("What does SAP ERP mean? ",
                "SAP ERP is a system hardware that includes modules for purchasing, sales and distribution,  materials management, production and so on. ",
                "SAP ERP is a technological platform on the basis of which customer-specific extensions can be  imported. ",
                "SAP ERP is an application that an enterprise can use to manage its business processes efficiently. ",
                "SAP ERP is a planning system in which extended planning processes can be mapped.",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f70);

        Question f71 = new Question("Which of the following statements is true for the simulation mode in the context of material requirements planning in SAP ECC? ",
                "The simulation mode is used in scenarios in which requirements planning created the procurement  element prematurely in terms of demand. ",
                "The simulation mode opens the analysis of the delay time. Manual rescheduling of the receipt in the  finished product and subsequent requirements planning lead to a solution that is feasible from the requirements planning perspective. However, this solution may lead to a date/time violation in the  finished product. ",
                "The simulation mode represents an interactive multilevel form of planning, the result of which is  automatically posted to the database after the planning run. ",
                "Assuming a delay time in the critical path, the simulation mode triggers multilevel bottom-up scheduling through to the finished product, which therefore receives a delayed receipt. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f71);

        Question f72 = new Question("Which of the following features are offered by MRP Areas (Material Requirements Planning Areas)? (Choose two.) ",
                "An MRP Area may include different storage locations. ",
                "Subcontracting is supported by MRP Areas. ",
                "A storage location may be assigned to different MRP Areas. ",
                "Make-to-order production is supported by storage location MRP Areas. ",
                null,
                null,
                "X", "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f72);

        Question f73 = new Question("A supply chain planning run is to be carried out in the SAP ECC system as an example. What would be the most effective sequence in which to run through the planning modules? ",
                "1. Long-term planning  2. Sales and Operations Planning  3. Demand management  4. Requirements planning  5. Capacity planning ",
                "1. Sales and Operations Planning  2. Demand management  3. Long-term planning  4. Requirements planning  5. Capacity planning ",
                "1. Capacity planning  2. Sales and Operations Planning  3. Demand management  4. Long-term planning  5. Requirements planning ",
                "1. Demand management  2. Sales and Operations Planning  3. Capacity planning  4. Long-term planning  5. Requirements planning ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f73);

        Question f74 = new Question("An enterprise wants to use SAP ECC requirements planning together with the NETPL procedure (net change planning in the planning horizon). The planning horizon is to be set equally for all materials by default. However, some materials are to be given a different planning horizon. What procedure would you recommend to the project team for setting the planning horizon on the system side?",
                "The planning horizon is set in the MRP groups in Customizing and variant entries are assigned via  the plant parameter settings",
                "The planning horizon is set in Customizing using the plant parameter setting and variant entries are  assigned via the MRP groups for the materials in question. ",
                "The planning horizon is set in the MRP groups in Customizing and the variant values are stored in  the material masters for the materials in question. ",
                "The planning horizon is set in the plant parameters in Customizing and variant entries are stored in  the material masters for the materials in question. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f74);

        Question f75 = new Question("Which of the following efforts can be minimized using the KANBAN procedure? ",
                "Organizational effort to stage material ",
                "Organizational effort for capacity planning ",
                "Effort for master data maintenance ",
                "Effort for Sales and Operations Planning (SOP) ",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f75);

        Question f76 = new Question("In the SAP ECC system, a material is produced with the help of production orders. Though originally used for rate-based planning only, the planning table is to be used to plan this material. On the initial screen of the planning table, you select this material and then receive a message informing you that you cannot use the planning table for this material. Which one of the following reasons for this message applies?",
                "The series production indicator has not been set. ",
                "There is no valid production version for this material. ",
                "There are no planned orders or production orders present. ",
                "There are no requirements present. ",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f76);

        Question f77 = new Question("Which functions lead to a reduction in the capacity requirement for an individual operation at a work center? (Choose three.) ",
                "Rescheduling the operation ",
                "Posting the goods receipt for the production order ",
                "Setting the status technically complete (TECO) ",
                "Confirming the operation ",
                "Reducing the order quantity \n",
                null,
                null, null, "X", "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f77);

        Question f78 = new Question("With which functions of the process order can you fulfill the requirements of the Good Manufacturing Practices (GMP) standard? (Choose three.) ",
                "Material identification and reconciliation ",
                "Availability check ",
                "Batch record ",
                "Resource selection ",
                "Digital signature ",
                null,
                "X", null, "X", null, "X", null, Question.C_TSCM42_65);
        addQuestion(f78);

        Question f79 = new Question("The company you advise wants to control the availability check in so that when a production and/or process order is created, the following receipts or issues are taken into account: planned orders, purchase orders, production orders, reservations, dependent requirements. When the production and/or process order is released, only the stock that is currently freely usable should be taken into consideration. How can you fulfill this request? \n" +
                " ",
                "Differentiated assignment of two different checking rules in check control. ",
                "Activate the freely usable stock in the scope of check. ",
                "Enter an appropriate availability checking group in the material master. ",
                "Enter an appropriate availability checking rule in the order type. \n",
                null,
                null,
                "X", null, null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f79);

        Question f80 = new Question("Which of the following statements is true for the ATP (available to promise) availability check in SAP ECC that is triggered from a customer order? ",
                "The ATP check does not confirm against stocks and receipts, it checks consumption against planning requirements. ",
                "An availability check by means of ATP creates fixed links between customer orders and their confirmed receipts",
                "The ATP quantity is the quantity still available that can be used to confirm incoming customer orders. ",
                "If the ATP check establishes non-availability, it checks whether it is still possible to procure or produce  in time. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f80);

        Question f81 = new Question("Which of the following master data do you need to make available for repetitive manufacturing? (Choose three.) ",
                "Master records for serial numbers ",
                "Repetitive manufacturing profile ",
                "Production supply area ",
                "Production versions ",
                "Product cost collector ",
                null,
                null, "X", null, "X", "X", null, Question.C_TSCM42_65);
        addQuestion(f81);

        Question f82 = new Question("Which statements are true for ECC Long-Term Planning (LTP)? (Choose two.) ",
                "Reorder point planned materials can be included in long-term planning.",
                "In case of external procurement, long-term planning creates purchase requisitions. ",
                "A planning scenario must be released to use it in long-term planning. ",
                "Long-term planning generally is operational planning of important components. \n",
                null,
                null,
                "X", null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f82);

        Question f83 = new Question("Which production order function can no longer be carried out after the order is released? ",
                "Read PP master data. ",
                "Switching sequences. ",
                "Posting a goods issue from stock to the production order. ",
                "Posting a goods receipt from production to stock. \n",
                null,
                null,
                null, "X", null, null, null, null, Question.C_TSCM42_65);
        addQuestion(f83);

        Question f84 = new Question("Which of the following activities is necessary for the capacity availability check to be carried out automatically when a production order is released? ",
                "Activate the availability check and assign a checking rule to the work center for the operation to  be checked. ",
                "Activate the availability check and assign the check control to the plant. ",
                "Activate the availability check and assign an overall profile in check control for the business function  order release. ",
                "Activate the availability check and assign an availability checking group to the material master for  the product to be produced. ",
                null,
                null,
                null, null, "X", null, null, null, Question.C_TSCM42_65);
        addQuestion(f84);

        Question f85 = new Question("A project team member analyzes the following situation in SAP ECC in the stock/requirements list for a finished product: there is only one customer order and one fixed planned order with a similar quantity amount. The customer order and the planned order both have deadlines on work days but not on the same work day; the planned order has a later deadline. The project team member cannot find a rescheduling message referring to this deadline misalignment in the stock/requirements list. What reasons could there be for the missing message? (Choose two.) ",
                "Requirement planning has not yet been carried out to update the rescheduling message. ",
                "The elements are linked to each other via fixed pegging.",
                "The time misalignment falls within the tolerance window defined in Customizing. ",
                "The requirement coverage element is outside the rescheduling horizon. ",
                null,
                null,
                null, null, "X", "X", null, null, Question.C_TSCM42_65);
        addQuestion(f85);

    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_OPTION5, question.getOption5());
        cv.put(QuestionsTable.COLUMN_OPTION6, question.getOption6());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR1, question.getAnswerNr1());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR2, question.getAnswerNr2());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR3, question.getAnswerNr3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR4, question.getAnswerNr4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR5, question.getAnswerNr5());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR6, question.getAnswerNr6());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList <Question> getAllQuestions() {
        ArrayList <Question> questionList = new ArrayList <>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setOption5(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION5)));
                question.setOption6(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION6)));
                question.setAnswerNr1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR1)));
                question.setAnswerNr2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR2)));
                question.setAnswerNr3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR3)));
                question.setAnswerNr4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR4)));
                question.setAnswerNr5(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR5)));
                question.setAnswerNr6(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR6)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);

            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public ArrayList <Question> getQuestions(String difficulty) {
        ArrayList <Question> questionList = new ArrayList <>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};

        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " =?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setOption5(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION5)));
                question.setOption6(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION6)));
                question.setAnswerNr1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR1)));
                question.setAnswerNr2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR2)));
                question.setAnswerNr3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR3)));
                question.setAnswerNr4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR4)));
                question.setAnswerNr5(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR5)));
                question.setAnswerNr6(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR6)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);

            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
