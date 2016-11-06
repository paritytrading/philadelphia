package com.paritytrading.philadelphia.fix50;

/**
 * Enumerations for FIX 5.0.
 */
public class FIX50Enumerations {

    /**
     * Values for AdvSide(4).
     */
    public static class AdvSideValues {

        public static final char Buy   = 'B';
        public static final char Sell  = 'S';
        public static final char Trade = 'T';
        public static final char Cross = 'X';

        private AdvSideValues() {
        }

    }

    /**
     * Values for AdvTransType(5).
     */
    public static class AdvTransTypeValues {

        public static final String New     = "N";
        public static final String Cancel  = "C";
        public static final String Replace = "R";

        private AdvTransTypeValues() {
        }

    }

    /**
     * Values for CommType(13).
     */
    public static class CommTypeValues {

        public static final char PerUnit                       = '1';
        public static final char Percent                       = '2';
        public static final char Absolute                      = '3';
        public static final char PercentageWaivedCashDiscount  = '4';
        public static final char PercentageWaivedEnhancedUnits = '5';
        public static final char PointsPerBondOrContract       = '6';

        private CommTypeValues() {
        }

    }

    /**
     * Values for ExecInst(18).
     */
    public static class ExecInstValues {

        public static final char StayOnOfferSide                            = '0';
        public static final char NotHeld                                    = '1';
        public static final char Work                                       = '2';
        public static final char GoAlong                                    = '3';
        public static final char OverTheDay                                 = '4';
        public static final char Held                                       = '5';
        public static final char ParticipateDoNotInitiate                   = '6';
        public static final char StrictScale                                = '7';
        public static final char TryToScale                                 = '8';
        public static final char StayOnBidSide                              = '9';
        public static final char NoCross                                    = 'A';
        public static final char OKToCross                                  = 'B';
        public static final char CallFirst                                  = 'C';
        public static final char PercentOfVolume                            = 'D';
        public static final char DoNotIncrease                              = 'E';
        public static final char DoNotReduce                                = 'F';
        public static final char AllOrNone                                  = 'G';
        public static final char ReinstateOnSystemFailure                   = 'H';
        public static final char InstitutionsOnly                           = 'I';
        public static final char ReinstateOnTradingHalt                     = 'J';
        public static final char CancelOnTradingHalt                        = 'K';
        public static final char LastPeg                                    = 'L';
        public static final char MidPricePeg                                = 'M';
        public static final char NonNegotiable                              = 'N';
        public static final char OpeningPeg                                 = 'O';
        public static final char MarketPeg                                  = 'P';
        public static final char CancelOnSystemFailure                      = 'Q';
        public static final char PrimaryPeg                                 = 'R';
        public static final char Suspend                                    = 'S';
        public static final char FixedPegToLocalBestBidOrOfferAtTimeOfOrder = 'T';
        public static final char CustomerDisplayInstruction                 = 'U';
        public static final char Netting                                    = 'V';
        public static final char PegToVWAP                                  = 'W';
        public static final char TradeAlong                                 = 'X';
        public static final char TryToStop                                  = 'Y';
        public static final char CancelIfNotBest                            = 'Z';
        public static final char TrailingStopPeg                            = 'a';
        public static final char StrictLimit                                = 'b';
        public static final char IgnorePriceValidityChecks                  = 'c';
        public static final char PegToLimitPrice                            = 'd';
        public static final char WorkToTargetStrategy                       = 'e';
        public static final char IntermarketSweep                           = 'f';
        public static final char ExternalRoutingAllowed                     = 'g';
        public static final char ExternalRoutingNotAllowed                  = 'h';
        public static final char ImbalanceOnly                              = 'i';
        public static final char SingleExecutionRequestedForBlockTrade      = 'j';
        public static final char BestExecution                              = 'k';

        private ExecInstValues() {
        }

    }

    /**
     * Values for HandlInst(21).
     */
    public static class HandlInstValues {

        public static final char AutomatedExecutionNoIntervention = '1';
        public static final char AutomatedExecutionInterventionOK = '2';
        public static final char ManualOrder                      = '3';

        private HandlInstValues() {
        }

    }

    /**
     * Values for SecurityIDSource(22).
     */
    public static class SecurityIDSourceValues {

        public static final String CUSIP                         = "1";
        public static final String SEDOL                         = "2";
        public static final String QUIK                          = "3";
        public static final String ISINNumber                    = "4";
        public static final String RICCode                       = "5";
        public static final String ISOCurrencyCode               = "6";
        public static final String ISOCountryCode                = "7";
        public static final String ExchangeSymbol                = "8";
        public static final String ConsolidatedTapeAssociation   = "9";
        public static final String BloombergSymbol               = "A";
        public static final String Wertpapier                    = "B";
        public static final String Dutch                         = "C";
        public static final String Valoren                       = "D";
        public static final String Sicovam                       = "E";
        public static final String Belgian                       = "F";
        public static final String Common                        = "G";
        public static final String ClearingHouse                 = "H";
        public static final String ISDAFpMLSpecification         = "I";
        public static final String OptionPriceReportingAuthority = "J";
        public static final String ISDAFpMLURL                   = "K";
        public static final String LetterOfCredit                = "L";

        private SecurityIDSourceValues() {
        }

    }

    /**
     * Values for IOIQltyInd(25).
     */
    public static class IOIQltyIndValues {

        public static final char High   = 'H';
        public static final char Low    = 'L';
        public static final char Medium = 'M';

        private IOIQltyIndValues() {
        }

    }

    /**
     * Values for IOIQty(27).
     */
    public static class IOIQtyValues {

        public static final String Small               = "S";
        public static final String Medium              = "M";
        public static final String Large               = "L";
        public static final String UndisclosedQuantity = "U";

        private IOIQtyValues() {
        }

    }

    /**
     * Values for IOITransType(28).
     */
    public static class IOITransTypeValues {

        public static final char New     = 'N';
        public static final char Cancel  = 'C';
        public static final char Replace = 'R';

        private IOITransTypeValues() {
        }

    }

    /**
     * Values for LastCapacity(29).
     */
    public static class LastCapacityValues {

        public static final char Agent            = '1';
        public static final char CrossAsAgent     = '2';
        public static final char CrossAsPrincipal = '3';
        public static final char Principal        = '4';

        private LastCapacityValues() {
        }

    }

    /**
     * Values for OrdStatus(39).
     */
    public static class OrdStatusValues {

        public static final char New                = '0';
        public static final char PartiallyFilled    = '1';
        public static final char Filled             = '2';
        public static final char DoneForDay         = '3';
        public static final char Canceled           = '4';
        public static final char Replaced           = '5';
        public static final char PendingCancel      = '6';
        public static final char Stopped            = '7';
        public static final char Rejected           = '8';
        public static final char Suspended          = '9';
        public static final char PendingNew         = 'A';
        public static final char Calculated         = 'B';
        public static final char Expired            = 'C';
        public static final char AcceptedForBidding = 'D';
        public static final char PendingReplace     = 'E';

        private OrdStatusValues() {
        }

    }

    /**
     * Values for OrdType(40).
     */
    public static class OrdTypeValues {

        public static final char Market                     = '1';
        public static final char Limit                      = '2';
        public static final char Stop                       = '3';
        public static final char StopLimit                  = '4';
        public static final char MarketOnClose              = '5';
        public static final char WithOrWithout              = '6';
        public static final char LimitOrBetter              = '7';
        public static final char LimitWithOrWithout         = '8';
        public static final char OnBasis                    = '9';
        public static final char OnClose                    = 'A';
        public static final char LimitOnClose               = 'B';
        public static final char ForexMarket                = 'C';
        public static final char PreviouslyQuoted           = 'D';
        public static final char PreviouslyIndicated        = 'E';
        public static final char ForexLimit                 = 'F';
        public static final char ForexSwap                  = 'G';
        public static final char ForexPreviouslyQuoted      = 'H';
        public static final char Funari                     = 'I';
        public static final char MarketIfTouched            = 'J';
        public static final char MarketWithLeftOverAsLimit  = 'K';
        public static final char PreviousFundValuationPoint = 'L';
        public static final char NextFundValuationPoint     = 'M';
        public static final char Pegged                     = 'P';
        public static final char CounterOrderSelection      = 'Q';

        private OrdTypeValues() {
        }

    }

    /**
     * Values for Side(54).
     */
    public static class SideValues {

        public static final char Buy              = '1';
        public static final char Sell             = '2';
        public static final char BuyMinus         = '3';
        public static final char SellPlus         = '4';
        public static final char SellShort        = '5';
        public static final char SellShortExempt  = '6';
        public static final char Undisclosed      = '7';
        public static final char Cross            = '8';
        public static final char CrossShort       = '9';
        public static final char CrossShortExempt = 'A';
        public static final char AsDefined        = 'B';
        public static final char Opposite         = 'C';
        public static final char Subscribe        = 'D';
        public static final char Redeem           = 'E';
        public static final char Lend             = 'F';
        public static final char Borrow           = 'G';

        private SideValues() {
        }

    }

    /**
     * Values for TimeInForce(59).
     */
    public static class TimeInForceValues {

        public static final char Day               = '0';
        public static final char GoodTillCancel    = '1';
        public static final char AtTheOpening      = '2';
        public static final char ImmediateOrCancel = '3';
        public static final char FillOrKill        = '4';
        public static final char GoodTillCrossing  = '5';
        public static final char GoodTillDate      = '6';
        public static final char AtTheClose        = '7';

        private TimeInForceValues() {
        }

    }

    /**
     * Values for Urgency(61).
     */
    public static class UrgencyValues {

        public static final char Normal     = '0';
        public static final char Flash      = '1';
        public static final char Background = '2';

        private UrgencyValues() {
        }

    }

    /**
     * Values for SettlType(63).
     */
    public static class SettlTypeValues {

        public static final String Regular              = "0";
        public static final String Cash                 = "1";
        public static final String NextDay              = "2";
        public static final String TPlus2               = "3";
        public static final String TPlus3               = "4";
        public static final String TPlus4               = "5";
        public static final String Future               = "6";
        public static final String WhenAndIfIssued      = "7";
        public static final String SellersOption        = "8";
        public static final String TPlus5               = "9";
        public static final String BrokenDate           = "B";
        public static final String FXSpotNextSettlement = "C";

        private SettlTypeValues() {
        }

    }

    /**
     * Values for SymbolSfx(65).
     */
    public static class SymbolSfxValues {

        public static final String EUCPWithLumpSumInterest = "CD";
        public static final String WhenIssued              = "WI";

        private SymbolSfxValues() {
        }

    }

    /**
     * Values for AllocTransType(71).
     */
    public static class AllocTransTypeValues {

        public static final char New                          = '0';
        public static final char Replace                      = '1';
        public static final char Cancel                       = '2';
        public static final char Preliminary                  = '3';
        public static final char Calculated                   = '4';
        public static final char CalculatedWithoutPreliminary = '5';
        public static final char Reversal                     = '6';

        private AllocTransTypeValues() {
        }

    }

    /**
     * Values for PositionEffect(77).
     */
    public static class PositionEffectValues {

        public static final char Close  = 'C';
        public static final char FIFO   = 'F';
        public static final char Open   = 'O';
        public static final char Rolled = 'R';

        private PositionEffectValues() {
        }

    }

    /**
     * Values for ProcessCode(81).
     */
    public static class ProcessCodeValues {

        public static final char Regular           = '0';
        public static final char SoftDollar        = '1';
        public static final char StepIn            = '2';
        public static final char StepOut           = '3';
        public static final char SoftDollarStepIn  = '4';
        public static final char SoftDollarStepOut = '5';
        public static final char PlanSponsor       = '6';

        private ProcessCodeValues() {
        }

    }

    /**
     * Values for AllocStatus(87).
     */
    public static class AllocStatusValues {

        public static final int Accepted               = 0;
        public static final int BlockLevelReject       = 1;
        public static final int AccountLevelReject     = 2;
        public static final int Received               = 3;
        public static final int Incomplete             = 4;
        public static final int RejectedByIntermediary = 5;
        public static final int AllocationPending      = 6;
        public static final int Reversed               = 7;

        private AllocStatusValues() {
        }

    }

    /**
     * Values for AllocRejCode(88).
     */
    public static class AllocRejCodeValues {

        public static final int UnknownAccount                 =  0;
        public static final int IncorrectQuantity              =  1;
        public static final int IncorrectAveragegPrice         =  2;
        public static final int UnknownExecutingBrokerMnemonic =  3;
        public static final int CommissionDifference           =  4;
        public static final int UnknownOrderID                 =  5;
        public static final int UnknownListID                  =  6;
        public static final int OtherSeeText                   =  7;
        public static final int IncorrectAllocatedQuantity     =  8;
        public static final int CalculationDifference          =  9;
        public static final int UnknownOrStaleExecID           = 10;
        public static final int MismatchedData                 = 11;
        public static final int UnknownClOrdID                 = 12;
        public static final int WarehouseRequestRejected       = 13;

        private AllocRejCodeValues() {
        }

    }

    /**
     * Values for EmailType(94).
     */
    public static class EmailTypeValues {

        public static final char New        = '0';
        public static final char Reply      = '1';
        public static final char AdminReply = '2';

        private EmailTypeValues() {
        }

    }

    /**
     * Values for EncryptMethod(98).
     */
    public static class EncryptMethodValues {

        public static final int None      = 0;
        public static final int PKCS      = 1;
        public static final int DES       = 2;
        public static final int PKCSDES   = 3;
        public static final int PGPDES    = 4;
        public static final int PGPDESMD5 = 5;
        public static final int PEM       = 6;

        private EncryptMethodValues() {
        }

    }

    /**
     * Values for CxlRejReason(102).
     */
    public static class CxlRejReasonValues {

        public static final int TooLateToCancel                       =  0;
        public static final int UnknownOrder                          =  1;
        public static final int BrokerCredit                          =  2;
        public static final int OrderAlreadyInPendingStatus           =  3;
        public static final int UnableToProcessOrderMassCancelRequest =  4;
        public static final int OrigOrdModTime                        =  5;
        public static final int DuplicateClOrdID                      =  6;
        public static final int InvalidPriceIncrement                 = 18;
        public static final int Other                                 = 99;

        private CxlRejReasonValues() {
        }

    }

    /**
     * Values for OrdRejReason(103).
     */
    public static class OrdRejReasonValues {

        public static final int BrokerCredit                          =  0;
        public static final int UnknownSymbol                         =  1;
        public static final int ExchangeClosed                        =  2;
        public static final int OrderExceedsLimit                     =  3;
        public static final int TooLateToEnter                        =  4;
        public static final int UnknownOrder                          =  5;
        public static final int DuplicateOrder                        =  6;
        public static final int DuplicateOfAVerballyCommunicatedOrder =  7;
        public static final int StaleOrder                            =  8;
        public static final int TradeAlongRequired                    =  9;
        public static final int InvalidInvestorID                     = 10;
        public static final int UnsupportedOrderCharacteristic        = 11;
        public static final int SurveillenceOption                    = 12;
        public static final int IncorrectQuantity                     = 13;
        public static final int IncorrectAllocatedQuantity            = 14;
        public static final int UnknownAccount                        = 15;
        public static final int InvalidPriceIncrement                 = 18;
        public static final int Other                                 = 99;

        private OrdRejReasonValues() {
        }

    }

    /**
     * Values for IOIQualifier(104).
     */
    public static class IOIQualifierValues {

        public static final char AllOrNone           = 'A';
        public static final char MarketOnClose       = 'B';
        public static final char AtTheClose          = 'C';
        public static final char VWAP                = 'D';
        public static final char InTouchWith         = 'I';
        public static final char Limit               = 'L';
        public static final char MoreBehind          = 'M';
        public static final char AtTheOpen           = 'O';
        public static final char TakingAPosition     = 'P';
        public static final char AtTheMarket         = 'Q';
        public static final char ReadyToTrade        = 'R';
        public static final char PortfolioShown      = 'S';
        public static final char ThroughTheDay       = 'T';
        public static final char Versus              = 'V';
        public static final char Indication          = 'W';
        public static final char CrossingOpportunity = 'X';
        public static final char AtTheMidpoint       = 'Y';
        public static final char PreOpen             = 'Z';

        private IOIQualifierValues() {
        }

    }

    /**
     * Values for DKReason(127).
     */
    public static class DKReasonValues {

        public static final char UnknownSymbol         = 'A';
        public static final char WrongSide             = 'B';
        public static final char QuantityExceedsOrder  = 'C';
        public static final char NoMatchingOrder       = 'D';
        public static final char PriceExceedsLimit     = 'E';
        public static final char CalculationDifference = 'F';
        public static final char Other                 = 'Z';

        private DKReasonValues() {
        }

    }

    /**
     * Values for MiscFeeType(139).
     */
    public static class MiscFeeTypeValues {

        public static final String Regulatory      = "1";
        public static final String Tax             = "2";
        public static final String LocalCommission = "3";
        public static final String ExchangeFees    = "4";
        public static final String Stamp           = "5";
        public static final String Levy            = "6";
        public static final String Other           = "7";
        public static final String Markup          = "8";
        public static final String ConsumptionTax  = "9";
        public static final String PerTransaction  = "10";
        public static final String Conversion      = "11";
        public static final String Agent           = "12";
        public static final String TransferFee     = "13";
        public static final String SecurityLending = "14";

        private MiscFeeTypeValues() {
        }

    }

    /**
     * Values for ExecType(150).
     */
    public static class ExecTypeValues {

        public static final char New                            = '0';
        public static final char DoneForDay                     = '3';
        public static final char Canceled                       = '4';
        public static final char Replaced                       = '5';
        public static final char PendingCancel                  = '6';
        public static final char Stopped                        = '7';
        public static final char Rejected                       = '8';
        public static final char Suspended                      = '9';
        public static final char PendingNew                     = 'A';
        public static final char Calculated                     = 'B';
        public static final char Expired                        = 'C';
        public static final char Restated                       = 'D';
        public static final char PendingReplace                 = 'E';
        public static final char Trade                          = 'F';
        public static final char TradeCorrect                   = 'G';
        public static final char TradeCancel                    = 'H';
        public static final char OrderStatus                    = 'I';
        public static final char TradeInAClearingHold           = 'J';
        public static final char TradeHasBeenReleasedToClearing = 'K';
        public static final char TriggeredOrActivatedBySystem   = 'L';

        private ExecTypeValues() {
        }

    }

    /**
     * Values for SettlCurrFxRateCalc(156).
     */
    public static class SettlCurrFxRateCalcValues {

        public static final char Multiply = 'M';
        public static final char Divide   = 'D';

        private SettlCurrFxRateCalcValues() {
        }

    }

    /**
     * Values for SettlInstMode(160).
     */
    public static class SettlInstModeValues {

        public static final char Default                             = '0';
        public static final char StandingInstructionsProvided        = '1';
        public static final char SpecificAllocationAccountOverriding = '2';
        public static final char SpecificAllocationAccountStanding   = '3';
        public static final char SpecificOrderForASingleAccount      = '4';
        public static final char RequestReject                       = '5';

        private SettlInstModeValues() {
        }

    }

    /**
     * Values for SettlInstTransType(163).
     */
    public static class SettlInstTransTypeValues {

        public static final char New     = 'N';
        public static final char Cancel  = 'C';
        public static final char Replace = 'R';
        public static final char Restate = 'T';

        private SettlInstTransTypeValues() {
        }

    }

    /**
     * Values for SettlInstSource(165).
     */
    public static class SettlInstSourceValues {

        public static final char BrokerCredit = '1';
        public static final char Institution  = '2';
        public static final char Investor     = '3';

        private SettlInstSourceValues() {
        }

    }

    /**
     * Values for SecurityType(167).
     */
    public static class SecurityTypeValues {

        public static final String EuroSupranationalCoupons                 = "EUSUPRA";
        public static final String CorporateBond                            = "CORP";
        public static final String ForeignExchangeContract                  = "FOR";
        public static final String CommonStock                              = "CS";
        public static final String Repurchase                               = "REPO";
        public static final String BradyBond                                = "BRADY";
        public static final String TermLoan                                 = "TERM";
        public static final String BankersAcceptance                        = "BA";
        public static final String AssetBackedSecurities                    = "ABS";
        public static final String OtherAnticipationNotes                   = "AN";
        public static final String MutualFund                               = "MF";
        public static final String Future                                   = "FUT";
        public static final String FederalAgencyCoupon                      = "FAC";
        public static final String CorporatePrivatePlacement                = "CPP";
        public static final String PreferredStock                           = "PS";
        public static final String Forward                                  = "FORWARD";
        public static final String EuroSovereigns                           = "EUSOV";
        public static final String RevolverLoan                             = "RVLV";
        public static final String BankNotes                                = "BN";
        public static final String Corp                                     = "CMBS";
        public static final String CertificateOfObligation                  = "COFO";
        public static final String MultilegInstrument                       = "MLEG";
        public static final String Option                                   = "OPT";
        public static final String FederalAgencyDiscountNote                = "FADN";
        public static final String ConvertibleBond                          = "CB";
        public static final String BuySellback                              = "BUYSELL";
        public static final String USTreasuryBond                           = "TBOND";
        public static final String Revolver                                 = "RVLVTRM";
        public static final String BillOfExchanges                          = "BOX";
        public static final String CollateralizedMortgageObligation         = "CMO";
        public static final String CertificateOfParticipation               = "COFP";
        public static final String NoSecurityType                           = "NONE";
        public static final String USTreasuryNoteOld                        = "UST";
        public static final String PrivateExportFunding                     = "PEF";
        public static final String DualCurrency                             = "DUAL";
        public static final String SecuritiesLoan                           = "SECLOAN";
        public static final String InterestStripFromAnyBondOrNote           = "TINT";
        public static final String BridgeLoan                               = "BRIDGE";
        public static final String CertificateOfDeposit                     = "CD";
        public static final String IOETTEMortgage                           = "IET";
        public static final String GeneralObligationBonds                   = "GO";
        public static final String OptionsOnFutures                         = "OOF";
        public static final String USTreasuryBillOld                        = "USTB";
        public static final String USDSupranationalCoupons                  = "SUPRA";
        public static final String EuroCorporateBond                        = "EUCORP";
        public static final String SecuritiesPledge                         = "SECPLEDGE";
        public static final String TreasuryInflationProtectedSecurities     = "TIPS";
        public static final String LetterOfCredit                           = "LOFC";
        public static final String CallLoans                                = "CL";
        public static final String MortgageBackedSecurities                 = "MBS";
        public static final String MandatoryTender                          = "MT";
        public static final String OptionsOnPhysical                        = "OOP";
        public static final String IndexedLinked                            = "XLINKD";
        public static final String PrincipalStripOfACallableBondOrNote      = "TCAL";
        public static final String SwingLineFacility                        = "SWING";
        public static final String CommercialPaper                          = "CP";
        public static final String MortgageInterestOnly                     = "MIO";
        public static final String RevenueAnticipationNote                  = "RAN";
        public static final String WildcardEntry                            = "WLD";
        public static final String StructuredNotes                          = "STRUCT";
        public static final String PrincipalStripFromANonCallableBondOrNote = "TPRN";
        public static final String DebtorInPossession                       = "DINP";
        public static final String DepositNotes                             = "DN";
        public static final String MortgagePrincipalOnly                    = "MPO";
        public static final String RevenueBonds                             = "REV";
        public static final String Cash                                     = "CASH";
        public static final String YankeeCorporateBond                      = "YANK";
        public static final String USTreasuryNote                           = "TNOTE";
        public static final String Defaulted                                = "DEFLTED";
        public static final String EuroCertificateOfDeposit                 = "EUCD";
        public static final String MortgagePrivatePlacement                 = "MPP";
        public static final String SpecialAssessment                        = "SPCLA";
        public static final String USTreasuryBill                           = "TBILL";
        public static final String Withdrawn                                = "WITHDRN";
        public static final String EuroCommercialPaper                      = "EUCP";
        public static final String MiscellaneousPassThrough                 = "MPT";
        public static final String SpecialObligation                        = "SPCLO";
        public static final String Replaced                                 = "REPLACD";
        public static final String LiquidityNote                            = "LQN";
        public static final String Pfandbriefe                              = "PFAND";
        public static final String SpecialTax                               = "SPCLT";
        public static final String Matured                                  = "MATURED";
        public static final String MediumTermNotes                          = "MTN";
        public static final String ToBeAnnounced                            = "TBA";
        public static final String TaxAnticipationNote                      = "TAN";
        public static final String Amended                                  = "AMENDED";
        public static final String Overnight                                = "ONITE";
        public static final String TaxAllocation                            = "TAXA";
        public static final String Retired                                  = "RETIRED";
        public static final String PromissoryNote                           = "PN";
        public static final String TaxExemptCommercialPaper                 = "TECP";
        public static final String PlazosFijos                              = "PZFJ";
        public static final String TaxRevenueAnticipationNote               = "TRAN";
        public static final String ShortTermLoanNote                        = "STN";
        public static final String VariableRateDemandNote                   = "VRDN";
        public static final String TimeDeposit                              = "TD";
        public static final String Warrant                                  = "WAR";
        public static final String ExtendedCommNote                         = "XCN";
        public static final String YankeeCertificateOfDeposit               = "YCD";

        private SecurityTypeValues() {
        }

    }

    /**
     * Values for StandInstDbType(169).
     */
    public static class StandInstDbTypeValues {

        public static final int Other            = 0;
        public static final int DTCSID           = 1;
        public static final int ThomsonALERT     = 2;
        public static final int AGlobalCustodian = 3;
        public static final int AccountNet       = 4;

        private StandInstDbTypeValues() {
        }

    }

    /**
     * Values for SettlDeliveryType(172).
     */
    public static class SettlDeliveryTypeValues {

        public static final int Versus        = 0;
        public static final int Free          = 1;
        public static final int TriParty      = 2;
        public static final int HoldInCustody = 3;

        private SettlDeliveryTypeValues() {
        }

    }

    /**
     * Values for AllocLinkType(197).
     */
    public static class AllocLinkTypeValues {

        public static final int FXNetting = 0;
        public static final int FXSwap    = 1;

        private AllocLinkTypeValues() {
        }

    }

    /**
     * Values for PutOrCall(201).
     */
    public static class PutOrCallValues {

        public static final int Put  = 0;
        public static final int Call = 1;

        private PutOrCallValues() {
        }

    }

    /**
     * Values for CoveredOrUncovered(203).
     */
    public static class CoveredOrUncoveredValues {

        public static final int Covered   = 0;
        public static final int Uncovered = 1;

        private CoveredOrUncoveredValues() {
        }

    }

    /**
     * Values for AllocHandlInst(209).
     */
    public static class AllocHandlInstValues {

        public static final int Match           = 1;
        public static final int Forward         = 2;
        public static final int ForwardAndMatch = 3;

        private AllocHandlInstValues() {
        }

    }

    /**
     * Values for RoutingType(216).
     */
    public static class RoutingTypeValues {

        public static final int TargetFirm = 1;
        public static final int TargetList = 2;
        public static final int BlockFirm  = 3;
        public static final int BlockList  = 4;

        private RoutingTypeValues() {
        }

    }

    /**
     * Values for BenchmarkCurveName(221).
     */
    public static class BenchmarkCurveNameValues {

        public static final String EONIA       = "EONIA";
        public static final String EUREPO      = "EUREPO";
        public static final String Euribor     = "Euribor";
        public static final String FutureSWAP  = "FutureSWAP";
        public static final String LIBID       = "LIBID";
        public static final String LIBOR       = "LIBOR";
        public static final String MuniAAA     = "MuniAAA";
        public static final String OTHER       = "OTHER";
        public static final String Pfandbriefe = "Pfandbriefe";
        public static final String SONIA       = "SONIA";
        public static final String SWAP        = "SWAP";
        public static final String Treasury    = "Treasury";

        private BenchmarkCurveNameValues() {
        }

    }

    /**
     * Values for StipulationType(233).
     */
    public static class StipulationTypeValues {

        public static final String AlternativeMinimumTax                       = "AMT";
        public static final String AbsolutePrepaymentSpeed                     = "ABS";
        public static final String AutoReinvestment                            = "AUTOREINV";
        public static final String ConstantPrepaymentPenalty                   = "CPP";
        public static final String BankQualified                               = "BANKQUAL";
        public static final String ConstantPrepaymentRate                      = "CPR";
        public static final String BargainConditions                           = "BGNCON";
        public static final String ConstantPrepaymentYield                     = "CPY";
        public static final String CouponRange                                 = "COUPON";
        public static final String FinalCPROfHomeEquityPrepaymentCurve         = "HEP";
        public static final String ISOCurrencyCode                             = "CURRENCY";
        public static final String PercentOfManufacturedHousingPrepaymentCurve = "MHP";
        public static final String CustomStart                                 = "CUSTOMDATE";
        public static final String MonthlyPrepaymentRate                       = "MPR";
        public static final String Geographics                                 = "GEOG";
        public static final String PercentOfProspectusPrepaymentCurve          = "PPC";
        public static final String ValuationDiscount                           = "HAIRCUT";
        public static final String PercentOfBMAPrepaymentCurve                 = "PSA";
        public static final String Insured                                     = "INSURED";
        public static final String SingleMonthlyMortality                      = "SMM";
        public static final String IssueDate                                   = "ISSUE";
        public static final String Issuer                                      = "ISSUER";
        public static final String IssueSizeRange                              = "ISSUESIZE";
        public static final String LookbackDays                                = "LOOKBACK";
        public static final String ExplicitLotIdentifier                       = "LOT";
        public static final String LotVariance                                 = "LOTVAR";
        public static final String MaturityYearAndMonth                        = "MAT";
        public static final String MaturityRange                               = "MATURITY";
        public static final String MaximumSubstitutions                        = "MAXSUBS";
        public static final String MinimumDenomination                         = "MINDNOM";
        public static final String MinimumIncrement                            = "MININCR";
        public static final String MinimumQuantity                             = "MINQTY";
        public static final String PaymentFrequency                            = "PAYFREQ";
        public static final String NumberOfPieces                              = "PIECES";
        public static final String PoolsMaximum                                = "PMAX";
        public static final String PoolsPerLot                                 = "PPL";
        public static final String PoolsPerMillion                             = "PPM";
        public static final String PoolsPerTrade                               = "PPT";
        public static final String PriceRange                                  = "PRICE";
        public static final String PricingFrequency                            = "PRICEFREQ";
        public static final String ProductionYear                              = "PROD";
        public static final String CallProtection                              = "PROTECT";
        public static final String Purpose                                     = "PURPOSE";
        public static final String BenchmarkPriceSource                        = "PXSOURCE";
        public static final String RatingSourceAndRange                        = "RATING";
        public static final String TypeOfRedemption                            = "REDEMPTION";
        public static final String Restricted                                  = "RESTRICTED";
        public static final String MarketSector                                = "SECTOR";
        public static final String SecurityTypeIncludedOrExcluded              = "SECTYPE";
        public static final String Structure                                   = "STRUCT";
        public static final String SubstitutionsFrequency                      = "SUBSFREQ";
        public static final String SubstitutionsLeft                           = "SUBSLEFT";
        public static final String FreeformText                                = "TEXT";
        public static final String TradeVariance                               = "TRDVAR";
        public static final String WeightedAverageCoupon                       = "WAC";
        public static final String WeightedAverageLifeCoupon                   = "WAL";
        public static final String WeightedAverageLoanAge                      = "WALA";
        public static final String WeightedAverageMaturity                     = "WAM";
        public static final String WholePool                                   = "WHOLE";
        public static final String YieldRange                                  = "YIELD";

        private StipulationTypeValues() {
        }

    }

    /**
     * Values for YieldType(235).
     */
    public static class YieldTypeValues {

        public static final String AfterTaxYield                 = "AFTERTAX";
        public static final String AnnualYield                   = "ANNUAL";
        public static final String YieldAtIssue                  = "ATISSUE";
        public static final String YieldToAverageMaturity        = "AVGMATURITY";
        public static final String BookYield                     = "BOOK";
        public static final String YieldToNextCall               = "CALL";
        public static final String YieldChangeSinceClose         = "CHANGE";
        public static final String ClosingYield                  = "CLOSE";
        public static final String CompoundYield                 = "COMPOUND";
        public static final String CurrentYield                  = "CURRENT";
        public static final String GvntEquivalentYield           = "GOVTEQUIV";
        public static final String TrueGrossYield                = "GROSS";
        public static final String YieldWithInflationAssumption  = "INFLATION";
        public static final String InverseFloaterBondYield       = "INVERSEFLOATER";
        public static final String MostRecentClosingYield        = "LASTCLOSE";
        public static final String ClosingYieldMostRecentMonth   = "LASTMONTH";
        public static final String ClosingYieldMostRecentQuarter = "LASTQUARTER";
        public static final String ClosingYieldMostRecentYear    = "LASTYEAR";
        public static final String YieldToLongestAverageLife     = "LONGAVGLIFE";
        public static final String MarkToMarketYield             = "MARK";
        public static final String YieldToMaturity               = "MATURITY";
        public static final String YieldToNextRefund             = "NEXTREFUND";
        public static final String OpenAverageYield              = "OPENAVG";
        public static final String PreviousCloseYield            = "PREVCLOSE";
        public static final String ProceedsYield                 = "PROCEEDS";
        public static final String YieldToNextPut                = "PUT";
        public static final String SemiAnnualYield               = "SEMIANNUAL";
        public static final String YieldToShortestAverageLife    = "SHORTAVGLIFE";
        public static final String SimpleYield                   = "SIMPLE";
        public static final String TaxEquivalentYield            = "TAXEQUIV";
        public static final String YieldToTenderDate             = "TENDER";
        public static final String TrueYield                     = "TRUE";
        public static final String YieldValueOf32nds             = "VALUE1_32";
        public static final String YieldToWorst                  = "WORST";

        private YieldTypeValues() {
        }

    }

    /**
     * Values for SubscriptionRequestType(263).
     */
    public static class SubscriptionRequestTypeValues {

        public static final char Snapshot                = '0';
        public static final char SnapshotAndUpdates      = '1';
        public static final char DisablePreviousSnapshot = '2';

        private SubscriptionRequestTypeValues() {
        }

    }

    /**
     * Values for MDUpdateType(265).
     */
    public static class MDUpdateTypeValues {

        public static final int FullRefresh        = 0;
        public static final int IncrementalRefresh = 1;

        private MDUpdateTypeValues() {
        }

    }

    /**
     * Values for MDEntryType(269).
     */
    public static class MDEntryTypeValues {

        public static final char Bid                      = '0';
        public static final char Offer                    = '1';
        public static final char Trade                    = '2';
        public static final char IndexValue               = '3';
        public static final char OpeningPrice             = '4';
        public static final char ClosingPrice             = '5';
        public static final char SettlementPrice          = '6';
        public static final char TradingSessionHighPrice  = '7';
        public static final char TradingSessionLowPrice   = '8';
        public static final char TradingSessionVWAPPrice  = '9';
        public static final char Imbalance                = 'A';
        public static final char TradeVolume              = 'B';
        public static final char OpenInterest             = 'C';
        public static final char CompositeUnderlyingPrice = 'D';
        public static final char SimulatedSellPrice       = 'E';
        public static final char SimulatedBuyPrice        = 'F';
        public static final char MarginRate               = 'G';
        public static final char MidPrice                 = 'H';
        public static final char EmptyBook                = 'J';
        public static final char SettleHighPrice          = 'K';
        public static final char SettleLowPrice           = 'L';
        public static final char PriorSettlePrice         = 'M';
        public static final char SessionHighBid           = 'N';
        public static final char SessionLowOffer          = 'O';
        public static final char EarlyPrices              = 'P';
        public static final char AuctionClearingPrice     = 'Q';

        private MDEntryTypeValues() {
        }

    }

    /**
     * Values for TickDirection(274).
     */
    public static class TickDirectionValues {

        public static final char PlusTick      = '0';
        public static final char ZeroPlusTick  = '1';
        public static final char MinusTick     = '2';
        public static final char ZeroMinusTick = '3';

        private TickDirectionValues() {
        }

    }

    /**
     * Values for QuoteCondition(276).
     */
    public static class QuoteConditionValues {

        public static final String Open                       = "A";
        public static final String Closed                     = "B";
        public static final String ExchangeBest               = "C";
        public static final String ConsolidatedBest           = "D";
        public static final String Locked                     = "E";
        public static final String Crossed                    = "F";
        public static final String Depth                      = "G";
        public static final String FastTrading                = "H";
        public static final String NonFirm                    = "I";
        public static final String Manual                     = "L";
        public static final String OutrightPrice              = "J";
        public static final String ImpliedPrice               = "K";
        public static final String DepthOnOffer               = "M";
        public static final String DepthOnBid                 = "N";
        public static final String Closing                    = "O";
        public static final String NewsDissemination          = "P";
        public static final String TradingRange               = "Q";
        public static final String OrderInflux                = "R";
        public static final String DueToRelated               = "S";
        public static final String NewsPending                = "T";
        public static final String AdditionalInfo             = "U";
        public static final String AdditionalInfoDueToRelated = "V";
        public static final String Resume                     = "W";
        public static final String ViewOfCommon               = "X";
        public static final String VolumeAlert                = "Y";
        public static final String OrderImbalance             = "Z";
        public static final String EquipmentChangeover        = "a";
        public static final String NoOpen                     = "b";
        public static final String RegularETH                 = "c";
        public static final String AutomaticExecution         = "d";
        public static final String AutomaticExecutionETH      = "e";
        public static final String FastMarketETH              = "f ";
        public static final String InactiveETH                = "g";
        public static final String Rotation                   = "h";
        public static final String RotationETH                = "i";
        public static final String Halt                       = "j";
        public static final String HaltETH                    = "k";
        public static final String DueToNewsDissemination     = "l";
        public static final String DueToNewsPending           = "m";
        public static final String TradingResume              = "n";
        public static final String OutOfSequence              = "o";
        public static final String BidSpecialist              = "p";
        public static final String OfferSpecialist            = "q";
        public static final String BidOfferSpecialist         = "r";
        public static final String EndOfDaySAM                = "s";
        public static final String ForbiddenSAM               = "t";
        public static final String FrozenSAM                  = "u";
        public static final String PreOpeningSAM              = "v";
        public static final String OpeningSAM                 = "w";
        public static final String OpenSAM                    = "x";
        public static final String SurveillanceSAM            = "y";
        public static final String SuspendedSAM               = "z";
        public static final String ReservedSAM                = "0";
        public static final String NoActiveSAM                = "1";
        public static final String Restricted                 = "2";

        private QuoteConditionValues() {
        }

    }

    /**
     * Values for TradeCondition(277).
     */
    public static class TradeConditionValues {

        public static final String Cash                                = "A";
        public static final String AveragePriceTrade                   = "B";
        public static final String CashTrade                           = "C";
        public static final String NextDay                             = "D";
        public static final String Opening                             = "E";
        public static final String IntradayTradeDetail                 = "F";
        public static final String Rule127Trade                        = "G";
        public static final String Rule155Trade                        = "H";
        public static final String SoldLast                            = "I";
        public static final String NextDayTrade                        = "J";
        public static final String Opened                              = "K";
        public static final String Seller                              = "L";
        public static final String Sold                                = "M";
        public static final String StoppedStock                        = "N";
        public static final String ImbalanceMoreBuyers                 = "P";
        public static final String ImbalanceMoreSellers                = "Q";
        public static final String OpeningPrice                        = "R";
        public static final String BargainCondition                    = "S";
        public static final String ConvertedPriceIndicator             = "T";
        public static final String ExchangeLast                        = "U";
        public static final String FinalPriceOfSession                 = "V";
        public static final String ExPit                               = "W";
        public static final String Crossed                             = "X";
        public static final String TradesResultingFromManual           = "Y";
        public static final String TradesResultingFromIntermarketSweep = "Z";
        public static final String VolumeOnly                          = "a";
        public static final String DirectPlus                          = "b";
        public static final String Acquisition                         = "c";
        public static final String Bunched                             = "d";
        public static final String Distribution                        = "e";
        public static final String BunchedSale                         = "f";
        public static final String SplitTrade                          = "g";
        public static final String CancelStopped                       = "h";
        public static final String CancelETH                           = "i";
        public static final String CancelStoppedETH                    = "j";
        public static final String OutOfSequenceETH                    = "k";
        public static final String CancelLastETH                       = "l";
        public static final String SoldLastSaleETH                     = "m";
        public static final String CancelLast                          = "n";
        public static final String SoldLastSale                        = "o";
        public static final String CancelOpen                          = "p";
        public static final String CancelOpenETH                       = "q";
        public static final String OpenedSaleETH                       = "r";
        public static final String CancelOnly                          = "s";
        public static final String CancelOnlyETH                       = "t";
        public static final String LateOpenETH                         = "u";
        public static final String AutoExecutionETH                    = "v";
        public static final String Reopen                              = "w";
        public static final String ReopenETH                           = "x";
        public static final String Adjusted                            = "y";
        public static final String AdjustedETH                         = "z";
        public static final String Spread                              = "AA";
        public static final String SpreadETH                           = "AB";
        public static final String Straddle                            = "AC";
        public static final String StraddleETH                         = "AD";
        public static final String Stopped                             = "AE";
        public static final String StoppedETH                          = "AF";
        public static final String RegularETH                          = "AG";
        public static final String Combo                               = "AH";
        public static final String ComboETH                            = "AI";
        public static final String OfficialClosingPrice                = "AJ";
        public static final String PriorReferencePrice                 = "AK";
        public static final String Cancel                              = "0";
        public static final String StoppedSoldLast                     = "AL";
        public static final String StoppedOutOfSequence                = "AM";
        public static final String OfficalClosingPrice                 = "AN";
        public static final String CrossedOld                          = "AO";
        public static final String FastMarket                          = "AP";
        public static final String AutomaticExecution                  = "AQ";
        public static final String FormT                               = "AR";
        public static final String BasketIndex                         = "AS";
        public static final String BurstBasket                         = "AT";

        private TradeConditionValues() {
        }

    }

    /**
     * Values for MDUpdateAction(279).
     */
    public static class MDUpdateActionValues {

        public static final char New        = '0';
        public static final char Change     = '1';
        public static final char Delete     = '2';
        public static final char DeleteThru = '3';
        public static final char DeleteFrom = '4';

        private MDUpdateActionValues() {
        }

    }

    /**
     * Values for MDReqRejReason(281).
     */
    public static class MDReqRejReasonValues {

        public static final char UnknownSymbol                      = '0';
        public static final char DuplicateMDReqID                   = '1';
        public static final char InsufficientBandwidth              = '2';
        public static final char InsufficientPermissions            = '3';
        public static final char UnsupportedSubscriptionRequestType = '4';
        public static final char UnsupportedMarketDepth             = '5';
        public static final char UnsupportedMDUpdateType            = '6';
        public static final char UnsupportedAggregatedBook          = '7';
        public static final char UnsupportedMDEntryType             = '8';
        public static final char UnsupportedTradingSessionID        = '9';
        public static final char UnsupportedScope                   = 'A';
        public static final char UnsupportedOpenCloseSettleFlag     = 'B';
        public static final char UnsupportedMDImplicitDelete        = 'C';
        public static final char InsufficientCredit                 = 'D';

        private MDReqRejReasonValues() {
        }

    }

    /**
     * Values for DeleteReason(285).
     */
    public static class DeleteReasonValues {

        public static final char Cancellation = '0';
        public static final char Error        = '1';

        private DeleteReasonValues() {
        }

    }

    /**
     * Values for OpenCloseSettlFlag(286).
     */
    public static class OpenCloseSettlFlagValues {

        public static final char DailyOpen                    = '0';
        public static final char SessionOpen                  = '1';
        public static final char DeliverySettlementEntry      = '2';
        public static final char ExpectedEntry                = '3';
        public static final char EntryFromPreviousBusinessDay = '4';
        public static final char TheoreticalPriceValue        = '5';

        private OpenCloseSettlFlagValues() {
        }

    }

    /**
     * Values for FinancialStatus(291).
     */
    public static class FinancialStatusValues {

        public static final char Bankrupt         = '1';
        public static final char PendingDelisting = '2';
        public static final char Restricted       = '3';

        private FinancialStatusValues() {
        }

    }

    /**
     * Values for CorporateAction(292).
     */
    public static class CorporateActionValues {

        public static final char ExDividend                = 'A';
        public static final char ExDistribution            = 'B';
        public static final char ExRights                  = 'C';
        public static final char New                       = 'D';
        public static final char ExInterest                = 'E';
        public static final char CashDividend              = 'F';
        public static final char StockDividend             = 'G';
        public static final char NonIntegerStockSplit      = 'H';
        public static final char ReverseStockSplit         = 'I';
        public static final char StandardIntegerStockSplit = 'J';
        public static final char PositionConsolidation     = 'K';
        public static final char LiquidationReorganization = 'L';
        public static final char MergerReorganization      = 'M';
        public static final char RightsOffering            = 'N';
        public static final char ShareholderMeeting        = 'O';
        public static final char Spinoff                   = 'P';
        public static final char TenderOffer               = 'Q';
        public static final char Warrant                   = 'R';
        public static final char SpecialAction             = 'S';
        public static final char SymbolConversion          = 'T';
        public static final char CUSIP                     = 'U';
        public static final char LeapRollover              = 'V';

        private CorporateActionValues() {
        }

    }

    /**
     * Values for QuoteStatus(297).
     */
    public static class QuoteStatusValues {

        public static final int Accepted                 =  0;
        public static final int CancelForSymbol          =  1;
        public static final int CanceledForSecurityType  =  2;
        public static final int CanceledForUnderlying    =  3;
        public static final int CanceledAll              =  4;
        public static final int Rejected                 =  5;
        public static final int RemovedFromMarket        =  6;
        public static final int Expired                  =  7;
        public static final int Query                    =  8;
        public static final int QuoteNotFound            =  9;
        public static final int Pending                  = 10;
        public static final int Pass                     = 11;
        public static final int LockedMarketWarning      = 12;
        public static final int CrossMarketWarning       = 13;
        public static final int CanceledDueToLockMarket  = 14;
        public static final int CanceledDueToCrossMarket = 15;

        private QuoteStatusValues() {
        }

    }

    /**
     * Values for QuoteCancelType(298).
     */
    public static class QuoteCancelTypeValues {

        public static final int CancelForOneOrMoreSecurities  = 1;
        public static final int CancelForSecurityType         = 2;
        public static final int CancelForUnderlyingSecurity   = 3;
        public static final int CancelAllQuotes               = 4;
        public static final int CancelQuoteSpecifiedInQuoteID = 5;

        private QuoteCancelTypeValues() {
        }

    }

    /**
     * Values for QuoteRejectReason(300).
     */
    public static class QuoteRejectReasonValues {

        public static final int UnknownSymbol                =  1;
        public static final int Exchange                     =  2;
        public static final int QuoteRequestExceedsLimit     =  3;
        public static final int TooLateToEnter               =  4;
        public static final int UnknownQuote                 =  5;
        public static final int DuplicateQuote               =  6;
        public static final int InvalidBid                   =  7;
        public static final int InvalidPrice                 =  8;
        public static final int NotAuthorizedToQuoteSecurity =  9;
        public static final int Other                        = 99;

        private QuoteRejectReasonValues() {
        }

    }

    /**
     * Values for QuoteResponseLevel(301).
     */
    public static class QuoteResponseLevelValues {

        public static final int NoAcknowledgement                        = 0;
        public static final int AcknowledgeOnlyNegativeOrErroneousQuotes = 1;
        public static final int AcknowledgeEachQuoteMessage              = 2;

        private QuoteResponseLevelValues() {
        }

    }

    /**
     * Values for QuoteRequestType(303).
     */
    public static class QuoteRequestTypeValues {

        public static final int Manual    = 1;
        public static final int Automatic = 2;

        private QuoteRequestTypeValues() {
        }

    }

    /**
     * Values for SecurityRequestType(321).
     */
    public static class SecurityRequestTypeValues {

        public static final int RequestSecurityIdentityAndSpecifications = 0;
        public static final int RequestSecurityIdentityForSpecifications = 1;
        public static final int RequestListSecurityTypes                 = 2;
        public static final int RequestListSecurities                    = 3;

        private SecurityRequestTypeValues() {
        }

    }

    /**
     * Values for SecurityResponseType(323).
     */
    public static class SecurityResponseTypeValues {

        public static final int AcceptAsIs                            = 1;
        public static final int AcceptWithRevisions                   = 2;
        public static final int ListOfSecurityTypesReturnedPerRequest = 3;
        public static final int ListOfSecuritiesReturnedPerRequest    = 4;
        public static final int RejectSecurityProposal                = 5;
        public static final int CannotMatchSelectionCriteria          = 6;

        private SecurityResponseTypeValues() {
        }

    }

    /**
     * Values for SecurityTradingStatus(326).
     */
    public static class SecurityTradingStatusValues {

        public static final int OpeningDelay               =  1;
        public static final int TradingHalt                =  2;
        public static final int Resume                     =  3;
        public static final int NoOpen                     =  4;
        public static final int PriceIndication            =  5;
        public static final int TradingRangeIndication     =  6;
        public static final int MarketImbalanceBuy         =  7;
        public static final int MarketImbalanceSell        =  8;
        public static final int MarketOnCloseImbalanceBuy  =  9;
        public static final int MarketOnCloseImbalanceSell = 10;
        public static final int NoMarketImbalance          = 12;
        public static final int NoMarketOnCloseImbalance   = 13;
        public static final int ITSPreOpening              = 14;
        public static final int NewPriceIndication         = 15;
        public static final int TradeDisseminationTime     = 16;
        public static final int ReadyToTrade               = 17;
        public static final int NotAvailableForTrading     = 18;
        public static final int NotTradedOnThisMarket      = 19;
        public static final int UnknownOrInvalid           = 20;
        public static final int PreOpen                    = 21;
        public static final int OpeningRotation            = 22;
        public static final int FastMarket                 = 23;

        private SecurityTradingStatusValues() {
        }

    }

    /**
     * Values for HaltReason(327).
     */
    public static class HaltReasonValues {

        public static final char NewsDissemination     = 'D';
        public static final char OrderInflux           = 'E';
        public static final char OrderImbalance        = 'I';
        public static final char AdditionalInformation = 'M';
        public static final char NewPending            = 'P';
        public static final char EquipmentChangeover   = 'X';

        private HaltReasonValues() {
        }

    }

    /**
     * Values for Adjustment(334).
     */
    public static class AdjustmentValues {

        public static final int Cancel     = 1;
        public static final int Error      = 2;
        public static final int Correction = 3;

        private AdjustmentValues() {
        }

    }

    /**
     * Values for TradSesMethod(338).
     */
    public static class TradSesMethodValues {

        public static final int Electronic = 1;
        public static final int OpenOutcry = 2;
        public static final int TwoParty   = 3;

        private TradSesMethodValues() {
        }

    }

    /**
     * Values for TradSesMode(339).
     */
    public static class TradSesModeValues {

        public static final int Testing    = 1;
        public static final int Simulated  = 2;
        public static final int Production = 3;

        private TradSesModeValues() {
        }

    }

    /**
     * Values for TradSesStatus(340).
     */
    public static class TradSesStatusValues {

        public static final int Unknown         = 0;
        public static final int Halted          = 1;
        public static final int Open            = 2;
        public static final int Closed          = 3;
        public static final int PreOpen         = 4;
        public static final int PreClose        = 5;
        public static final int RequestRejected = 6;

        private TradSesStatusValues() {
        }

    }

    /**
     * Values for SessionRejectReason(373).
     */
    public static class SessionRejectReasonValues {

        public static final int InvalidTagNumber                          =  0;
        public static final int RequiredTagMissing                        =  1;
        public static final int TagNotDefinedForThisMessageType           =  2;
        public static final int UndefinedTag                              =  3;
        public static final int TagSpecifiedWithoutAValue                 =  4;
        public static final int ValueIsIncorrect                          =  5;
        public static final int IncorrectDataFormatForValue               =  6;
        public static final int DecryptionProblem                         =  7;
        public static final int SignatureProblem                          =  8;
        public static final int CompIDProblem                             =  9;
        public static final int SendingTimeAccuracyProblem                = 10;
        public static final int InvalidMsgType                            = 11;
        public static final int XMLValidationError                        = 12;
        public static final int TagAppearsMoreThanOnce                    = 13;
        public static final int TagSpecifiedOutOfRequiredOrder            = 14;
        public static final int RepeatingGroupFieldsOutOfOrder            = 15;
        public static final int IncorrectNumInGroupCountForRepeatingGroup = 16;
        public static final int Non                                       = 17;
        public static final int Other                                     = 99;

        private SessionRejectReasonValues() {
        }

    }

    /**
     * Values for BidRequestTransType(374).
     */
    public static class BidRequestTransTypeValues {

        public static final char Cancel = 'C';
        public static final char New    = 'N';

        private BidRequestTransTypeValues() {
        }

    }

    /**
     * Values for ExecRestatementReason(378).
     */
    public static class ExecRestatementReasonValues {

        public static final int GTCorporateAction        =  0;
        public static final int GTRenewal                =  1;
        public static final int VerbalChange             =  2;
        public static final int RepricingOfOrder         =  3;
        public static final int BrokerOption             =  4;
        public static final int PartialDeclineOfOrderQty =  5;
        public static final int CancelOnTradingHalt      =  6;
        public static final int CancelOnSystemFailure    =  7;
        public static final int Market                   =  8;
        public static final int Canceled                 =  9;
        public static final int WarehouseRecap           = 10;
        public static final int PegRefresh               = 11;
        public static final int Other                    = 99;

        private ExecRestatementReasonValues() {
        }

    }

    /**
     * Values for BusinessRejectReason(380).
     */
    public static class BusinessRejectReasonValues {

        public static final int Other                               =  0;
        public static final int UnknownID                           =  1;
        public static final int UnknownSecurity                     =  2;
        public static final int UnsupportedMessageType              =  3;
        public static final int ApplicationNotAvailable             =  4;
        public static final int ConditionallyRequiredFieldMissing   =  5;
        public static final int NotAuthorized                       =  6;
        public static final int DeliverToFirmNotAvailableAtThisTime =  7;
        public static final int InvalidPriceIncrement               = 18;

        private BusinessRejectReasonValues() {
        }

    }

    /**
     * Values for MsgDirection(385).
     */
    public static class MsgDirectionValues {

        public static final char Receive = 'R';
        public static final char Send    = 'S';

        private MsgDirectionValues() {
        }

    }

    /**
     * Values for DiscretionInst(388).
     */
    public static class DiscretionInstValues {

        public static final char RelatedToDisplayedPrice    = '0';
        public static final char RelatedToMarketPrice       = '1';
        public static final char RelatedToPrimaryPrice      = '2';
        public static final char RelatedToLocalPrimaryPrice = '3';
        public static final char RelatedToMidpointPrice     = '4';
        public static final char RelatedToLastTradePrice    = '5';
        public static final char RelatedToVWAP              = '6';
        public static final char AveragePriceGuarantee      = '7';

        private DiscretionInstValues() {
        }

    }

    /**
     * Values for BidType(394).
     */
    public static class BidTypeValues {

        public static final int NonDisclosed     = 1;
        public static final int Disclosed        = 2;
        public static final int NoBiddingProcess = 3;

        private BidTypeValues() {
        }

    }

    /**
     * Values for BidDescriptorType(399).
     */
    public static class BidDescriptorTypeValues {

        public static final int Sector  = 1;
        public static final int Country = 2;
        public static final int Index   = 3;

        private BidDescriptorTypeValues() {
        }

    }

    /**
     * Values for SideValueInd(401).
     */
    public static class SideValueIndValues {

        public static final int SideValue1 = 1;
        public static final int SideValue2 = 2;

        private SideValueIndValues() {
        }

    }

    /**
     * Values for LiquidityIndType(409).
     */
    public static class LiquidityIndTypeValues {

        public static final int FiveDayMovingAverage   = 1;
        public static final int TwentyDayMovingAverage = 2;
        public static final int NormalMarketSize       = 3;
        public static final int Other                  = 4;

        private LiquidityIndTypeValues() {
        }

    }

    /**
     * Values for ProgRptReqs(414).
     */
    public static class ProgRptReqsValues {

        public static final int BuySideRequests          = 1;
        public static final int SellSideSends            = 2;
        public static final int RealTimeExecutionReports = 3;

        private ProgRptReqsValues() {
        }

    }

    /**
     * Values for IncTaxInd(416).
     */
    public static class IncTaxIndValues {

        public static final int Net   = 1;
        public static final int Gross = 2;

        private IncTaxIndValues() {
        }

    }

    /**
     * Values for BidTradeType(418).
     */
    public static class BidTradeTypeValues {

        public static final char Agency          = 'A';
        public static final char VWAPGuarantee   = 'G';
        public static final char GuaranteedClose = 'J';
        public static final char RiskTrade       = 'R';

        private BidTradeTypeValues() {
        }

    }

    /**
     * Values for BasisPxType(419).
     */
    public static class BasisPxTypeValues {

        public static final char ClosingPriceAtMorningSession        = '2';
        public static final char ClosingPrice                        = '3';
        public static final char CurrentPrice                        = '4';
        public static final char SQ                                  = '5';
        public static final char VWAPThroughADay                     = '6';
        public static final char VWAPThroughAMorningSession          = '7';
        public static final char VWAPThroughAnAfternoonSession       = '8';
        public static final char VWAPThroughADayExcept               = '9';
        public static final char VWAPThroughAMorningSessionExcept    = 'A';
        public static final char VWAPThroughAnAfternoonSessionExcept = 'B';
        public static final char Strike                              = 'C';
        public static final char Open                                = 'D';
        public static final char Others                              = 'Z';

        private BasisPxTypeValues() {
        }

    }

    /**
     * Values for PriceType(423).
     */
    public static class PriceTypeValues {

        public static final int Percentage                    =  1;
        public static final int PerUnit                       =  2;
        public static final int FixedAmount                   =  3;
        public static final int Discount                      =  4;
        public static final int Premium                       =  5;
        public static final int Spread                        =  6;
        public static final int TEDPrice                      =  7;
        public static final int TEDYield                      =  8;
        public static final int Yield                         =  9;
        public static final int FixedCabinetTradePrice        = 10;
        public static final int VariableCabinetTradePrice     = 11;
        public static final int ProductTicksInHalfs           = 13;
        public static final int ProductTicksInFourths         = 14;
        public static final int ProductTicksInEights          = 15;
        public static final int ProductTicksInSixteenths      = 16;
        public static final int ProductTicksInThirtySeconds   = 17;
        public static final int ProductTicksInSixtyForths     = 18;
        public static final int ProductTicksInOneTwentyEights = 19;

        private PriceTypeValues() {
        }

    }

    /**
     * Values for GTBookingInst(427).
     */
    public static class GTBookingInstValues {

        public static final int BookOutAllTradesOnDayOfExecution         = 0;
        public static final int AccumulateUntilFilledOrExpired           = 1;
        public static final int AccumulateUntilVerballyNotifiedOtherwise = 2;

        private GTBookingInstValues() {
        }

    }

    /**
     * Values for ListStatusType(429).
     */
    public static class ListStatusTypeValues {

        public static final int Ack         = 1;
        public static final int Response    = 2;
        public static final int Timed       = 3;
        public static final int ExecStarted = 4;
        public static final int AllDone     = 5;
        public static final int Alert       = 6;

        private ListStatusTypeValues() {
        }

    }

    /**
     * Values for NetGrossInd(430).
     */
    public static class NetGrossIndValues {

        public static final int Net   = 1;
        public static final int Gross = 2;

        private NetGrossIndValues() {
        }

    }

    /**
     * Values for ListOrderStatus(431).
     */
    public static class ListOrderStatusValues {

        public static final int InBiddingProcess     = 1;
        public static final int ReceivedForExecution = 2;
        public static final int Executing            = 3;
        public static final int Cancelling           = 4;
        public static final int Alert                = 5;
        public static final int AllDone              = 6;
        public static final int Reject               = 7;

        private ListOrderStatusValues() {
        }

    }

    /**
     * Values for ListExecInstType(433).
     */
    public static class ListExecInstTypeValues {

        public static final char Immediate             = '1';
        public static final char WaitForInstruction    = '2';
        public static final char SellDriven            = '3';
        public static final char BuyDrivenCashTopUp    = '4';
        public static final char BuyDrivenCashWithdraw = '5';

        private ListExecInstTypeValues() {
        }

    }

    /**
     * Values for CxlRejResponseTo(434).
     */
    public static class CxlRejResponseToValues {

        public static final char OrderCancelRequest        = '1';
        public static final char OrderCancel               = '2';
        public static final char OrderCancelReplaceRequest = '2';

        private CxlRejResponseToValues() {
        }

    }

    /**
     * Values for MultiLegReportingType(442).
     */
    public static class MultiLegReportingTypeValues {

        public static final char SingleSecurity                   = '1';
        public static final char IndividualLegOfAMultiLegSecurity = '2';
        public static final char MultiLegSecurity                 = '3';

        private MultiLegReportingTypeValues() {
        }

    }

    /**
     * Values for PartyIDSource(447).
     */
    public static class PartyIDSourceValues {

        public static final char UKNationalInsuranceOrPensionNumber = '6';
        public static final char KoreanInvestorID                   = '1';
        public static final char ISITCAcronym                       = 'I';
        public static final char BIC                                = 'B';
        public static final char USSocialSecurityNumber             = '7';
        public static final char TaiwaneseForeignInvestorID         = '2';
        public static final char GeneralIdentifier                  = 'C';
        public static final char USEmployerOrTaxIDNumber            = '8';
        public static final char TaiwaneseTradingAcct               = '3';
        public static final char Proprietary                        = 'D';
        public static final char AustralianBusinessNumber           = '9';
        public static final char MalaysianCentralDepository         = '4';
        public static final char ISOCountryCode                     = 'E';
        public static final char AustralianTaxFileNumber            = 'A';
        public static final char ChineseInvestorID                  = '5';
        public static final char SettlementEntityLocation           = 'F';
        public static final char MIC                                = 'G';
        public static final char CSDParticipant                     = 'H';

        private PartyIDSourceValues() {
        }

    }

    /**
     * Values for PartyRole(452).
     */
    public static class PartyRoleValues {

        public static final int ExecutingFirm                      =  1;
        public static final int BrokerOfCredit                     =  2;
        public static final int ClientID                           =  3;
        public static final int ClearingFirm                       =  4;
        public static final int InvestorID                         =  5;
        public static final int IntroducingFirm                    =  6;
        public static final int EnteringFirm                       =  7;
        public static final int Locate                             =  8;
        public static final int FundManagerClientID                =  9;
        public static final int SettlementLocation                 = 10;
        public static final int OrderOriginationTrader             = 11;
        public static final int ExecutingTrader                    = 12;
        public static final int OrderOriginationFirm               = 13;
        public static final int GiveupClearingFirm                 = 14;
        public static final int CorrespondantClearingFirm          = 15;
        public static final int ExecutingSystem                    = 16;
        public static final int ContraFirm                         = 17;
        public static final int ContraClearingFirm                 = 18;
        public static final int SponsoringFirm                     = 19;
        public static final int UnderlyingContraFirm               = 20;
        public static final int ClearingOrganization               = 21;
        public static final int Exchange                           = 22;
        public static final int CustomerAccount                    = 24;
        public static final int CorrespondentClearingOrganization  = 25;
        public static final int CorrespondentBroker                = 26;
        public static final int Buyer                              = 27;
        public static final int Custodian                          = 28;
        public static final int Intermediary                       = 29;
        public static final int Agent                              = 30;
        public static final int SubCustodian                       = 31;
        public static final int Beneficiary                        = 32;
        public static final int InterestedParty                    = 33;
        public static final int RegulatoryBody                     = 34;
        public static final int LiquidityProvider                  = 35;
        public static final int EnteringTrader                     = 36;
        public static final int ContraTrader                       = 37;
        public static final int PositionAccount                    = 38;
        public static final int ContraInvestorID                   = 39;
        public static final int TransferToFirm                     = 40;
        public static final int ContraPositionAccount              = 41;
        public static final int ContraExchange                     = 42;
        public static final int InternalCarryAccount               = 43;
        public static final int OrderEntryOperatorID               = 44;
        public static final int SecondaryAccountNumber             = 45;
        public static final int ForeignFirm                        = 46;
        public static final int ThirdPartyAllocationFirm           = 47;
        public static final int ClaimingAccount                    = 48;
        public static final int AssetManager                       = 49;
        public static final int PledgorAccount                     = 50;
        public static final int PledgeeAccount                     = 51;
        public static final int LargeTraderReportableAccount       = 52;
        public static final int TraderMnemonic                     = 53;
        public static final int SenderLocation                     = 54;
        public static final int SessionID                          = 55;
        public static final int AcceptableCounterparty             = 56;
        public static final int UnacceptableCounterparty           = 57;
        public static final int EnteringUnit                       = 58;
        public static final int ExecutingUnit                      = 59;
        public static final int IntroducingBroker                  = 60;
        public static final int QuoteOriginator                    = 61;
        public static final int ReportOriginator                   = 62;
        public static final int SystematicInternaliser             = 63;
        public static final int MultilateralTradingFacility        = 64;
        public static final int RegulatedMarket                    = 65;
        public static final int MarketMaker                        = 66;
        public static final int InvestmentFirm                     = 67;
        public static final int HostCompetentAuthority             = 68;
        public static final int HomeCompetentAuthority             = 69;
        public static final int CompetentAuthorityLiquidity        = 70;
        public static final int CompetentAuthorityTransactionVenue = 71;
        public static final int ReportingIntermediary              = 72;
        public static final int ExecutionVenue                     = 73;
        public static final int MarketDataEntryOriginator          = 74;
        public static final int LocationID                         = 75;
        public static final int DeskID                             = 76;
        public static final int MarketDataMarket                   = 77;
        public static final int AllocationEntity                   = 78;

        private PartyRoleValues() {
        }

    }

    /**
     * Values for Product(460).
     */
    public static class ProductValues {

        public static final int AGENCY      =  1;
        public static final int COMMODITY   =  2;
        public static final int CORPORATE   =  3;
        public static final int CURRENCY    =  4;
        public static final int EQUITY      =  5;
        public static final int GOVERNMENT  =  6;
        public static final int INDEX       =  7;
        public static final int LOAN        =  8;
        public static final int MONEYMARKET =  9;
        public static final int MORTGAGE    = 10;
        public static final int MUNICIPAL   = 11;
        public static final int OTHER       = 12;
        public static final int FINANCING   = 13;

        private ProductValues() {
        }

    }

    /**
     * Values for RoundingDirection(468).
     */
    public static class RoundingDirectionValues {

        public static final char RoundToNearest = '0';
        public static final char RoundDown      = '1';
        public static final char RoundUp        = '2';

        private RoundingDirectionValues() {
        }

    }

    /**
     * Values for DistribPaymentMethod(477).
     */
    public static class DistribPaymentMethodValues {

        public static final int CREST                        =  1;
        public static final int NSCC                         =  2;
        public static final int Euroclear                    =  3;
        public static final int Clearstream                  =  4;
        public static final int Cheque                       =  5;
        public static final int TelegraphicTransfer          =  6;
        public static final int FedWire                      =  7;
        public static final int DirectCredit                 =  8;
        public static final int ACHCredit                    =  9;
        public static final int BPAY                         = 10;
        public static final int HighValueClearingSystemHVACS = 11;
        public static final int ReinvestInFund               = 12;

        private DistribPaymentMethodValues() {
        }

    }

    /**
     * Values for CancellationRights(480).
     */
    public static class CancellationRightsValues {

        public static final char Yes               = 'Y';
        public static final char NoExecutionOnly   = 'N';
        public static final char NoWaiverAgreement = 'M';
        public static final char NoInstitutional   = 'O';

        private CancellationRightsValues() {
        }

    }

    /**
     * Values for MoneyLaunderingStatus(481).
     */
    public static class MoneyLaunderingStatusValues {

        public static final char Passed           = 'Y';
        public static final char NotChecked       = 'N';
        public static final char ExemptBelowLimit = '1';
        public static final char ExemptMoneyType  = '2';
        public static final char ExemptAuthorised = '3';

        private MoneyLaunderingStatusValues() {
        }

    }

    /**
     * Values for ExecPriceType(484).
     */
    public static class ExecPriceTypeValues {

        public static final char BidPrice                           = 'B';
        public static final char CreationPrice                      = 'C';
        public static final char CreationPricePlusAdjustmentPercent = 'D';
        public static final char CreationPricePlusAdjustmentAmount  = 'E';
        public static final char OfferPrice                         = 'O';
        public static final char OfferPriceMinusAdjustmentPercent   = 'P';
        public static final char OfferPriceMinusAdjustmentAmount    = 'Q';
        public static final char SinglePrice                        = 'S';

        private ExecPriceTypeValues() {
        }

    }

    /**
     * Values for TradeReportTransType(487).
     */
    public static class TradeReportTransTypeValues {

        public static final int New                       = 0;
        public static final int Cancel                    = 1;
        public static final int Replace                   = 2;
        public static final int Release                   = 3;
        public static final int Reverse                   = 4;
        public static final int CancelDueToBackOutOfTrade = 5;

        private TradeReportTransTypeValues() {
        }

    }

    /**
     * Values for PaymentMethod(492).
     */
    public static class PaymentMethodValues {

        public static final int CREST                   =  1;
        public static final int NSCC                    =  2;
        public static final int Euroclear               =  3;
        public static final int Clearstream             =  4;
        public static final int Cheque                  =  5;
        public static final int TelegraphicTransfer     =  6;
        public static final int FedWire                 =  7;
        public static final int DebitCard               =  8;
        public static final int DirectDebit             =  9;
        public static final int DirectCredit            = 10;
        public static final int CreditCard              = 11;
        public static final int ACHDebit                = 12;
        public static final int ACHCredit               = 13;
        public static final int BPAY                    = 14;
        public static final int HighValueClearingSystem = 15;

        private PaymentMethodValues() {
        }

    }

    /**
     * Values for TaxAdvantageType(495).
     */
    public static class TaxAdvantageTypeValues {

        public static final int None                          =   0;
        public static final int MaxiISA                       =   1;
        public static final int TESSA                         =   2;
        public static final int MiniCashISA                   =   3;
        public static final int MiniStocksAndSharesISA        =   4;
        public static final int MiniInsuranceISA              =   5;
        public static final int CurrentYearPayment            =   6;
        public static final int PriorYearPayment              =   7;
        public static final int AssetTransfer                 =   8;
        public static final int EmployeePriorYear             =   9;
        public static final int EmployeeCurrentYear           =  10;
        public static final int EmployerPriorYear             =  11;
        public static final int EmployerCurrentYear           =  12;
        public static final int NonFundPrototypeIRA           =  13;
        public static final int NonFundQualifiedPlan          =  14;
        public static final int DefinedContributionPlan       =  15;
        public static final int IRA                           =  16;
        public static final int IRARollover                   =  17;
        public static final int KEOGH                         =  18;
        public static final int ProfitSharingPlan             =  19;
        public static final int US401K                        =  20;
        public static final int SelfDirectedIRA               =  21;
        public static final int US403b                        =  22;
        public static final int US457                         =  23;
        public static final int RothIRAPrototype              =  24;
        public static final int RothIRANonPrototype           =  25;
        public static final int RothConversionIRAPrototype    =  26;
        public static final int RothConversionIRANonPrototype =  27;
        public static final int EducationIRAPrototype         =  28;
        public static final int EducationIRANonPrototype      =  29;
        public static final int Other                         = 999;

        private TaxAdvantageTypeValues() {
        }

    }

    /**
     * Values for FundRenewWaiv(497).
     */
    public static class FundRenewWaivValues {

        public static final char No  = 'N';
        public static final char Yes = 'Y';

        private FundRenewWaivValues() {
        }

    }

    /**
     * Values for RegistStatus(506).
     */
    public static class RegistStatusValues {

        public static final char Accepted = 'A';
        public static final char Rejected = 'R';
        public static final char Held     = 'H';
        public static final char Reminder = 'N';

        private RegistStatusValues() {
        }

    }

    /**
     * Values for RegistRejReasonCode(507).
     */
    public static class RegistRejReasonCodeValues {

        public static final int InvalidAccountType         =  1;
        public static final int InvalidTaxExemptType       =  2;
        public static final int InvalidOwnershipType       =  3;
        public static final int NoRegDetails               =  4;
        public static final int InvalidRegSeqNo            =  5;
        public static final int InvalidRegDetails          =  6;
        public static final int InvalidMailingDetails      =  7;
        public static final int InvalidMailingInstructions =  8;
        public static final int InvalidInvestorID          =  9;
        public static final int InvalidInvestorIDSource    = 10;
        public static final int InvalidDateOfBirth         = 11;
        public static final int InvalidCountry             = 12;
        public static final int InvalidDistribInstns       = 13;
        public static final int InvalidPercentage          = 14;
        public static final int InvalidPaymentMethod       = 15;
        public static final int InvalidAccountName         = 16;
        public static final int InvalidAgentCode           = 17;
        public static final int InvalidAccountNum          = 18;
        public static final int Other                      = 99;

        private RegistRejReasonCodeValues() {
        }

    }

    /**
     * Values for RegistTransType(514).
     */
    public static class RegistTransTypeValues {

        public static final char New     = '0';
        public static final char Cancel  = '2';
        public static final char Replace = '1';

        private RegistTransTypeValues() {
        }

    }

    /**
     * Values for OwnershipType(517).
     */
    public static class OwnershipTypeValues {

        public static final char JointInvestors  = 'J';
        public static final char TenantsInCommon = 'T';
        public static final char JointTrustees   = '2';

        private OwnershipTypeValues() {
        }

    }

    /**
     * Values for ContAmtType(519).
     */
    public static class ContAmtTypeValues {

        public static final int CommissionAmount                  =  1;
        public static final int CommissionPercent                 =  2;
        public static final int InitialChargeAmount               =  3;
        public static final int InitialChargePercent              =  4;
        public static final int DiscountAmount                    =  5;
        public static final int DiscountPercent                   =  6;
        public static final int DilutionLevyAmount                =  7;
        public static final int DilutionLevyPercent               =  8;
        public static final int ExitChargeAmount                  =  9;
        public static final int ExitChargePercent                 = 10;
        public static final int FundBasedRenewalCommissionPercent = 11;
        public static final int ProjectedFundValue                = 12;
        public static final int FundBasedRenewalCommissionOnOrder = 13;
        public static final int FundBasedRenewalCommissionOnFund  = 14;
        public static final int NetSettlementAmount               = 15;

        private ContAmtTypeValues() {
        }

    }

    /**
     * Values for OwnerType(522).
     */
    public static class OwnerTypeValues {

        public static final int IndividualInvestor             =  1;
        public static final int PublicCompany                  =  2;
        public static final int PrivateCompany                 =  3;
        public static final int IndividualTrustee              =  4;
        public static final int CompanyTrustee                 =  5;
        public static final int PensionPlan                    =  6;
        public static final int CustodianUnderGiftsToMinorsAct =  7;
        public static final int Trusts                         =  8;
        public static final int Fiduciaries                    =  9;
        public static final int NetworkingSubAccount           = 10;
        public static final int NonProfitOrganization          = 11;
        public static final int CorporateBody                  = 12;
        public static final int Nominee                        = 13;

        private OwnerTypeValues() {
        }

    }

    /**
     * Values for OrderCapacity(528).
     */
    public static class OrderCapacityValues {

        public static final char Agency              = 'A';
        public static final char Proprietary         = 'G';
        public static final char Individual          = 'I';
        public static final char Principal           = 'P';
        public static final char RisklessPrincipal   = 'R';
        public static final char AgentForOtherMember = 'W';

        private OrderCapacityValues() {
        }

    }

    /**
     * Values for OrderRestrictions(529).
     */
    public static class OrderRestrictionsValues {

        public static final char ProgramTrade                                = '1';
        public static final char IndexArbitrage                              = '2';
        public static final char NonIndexArbitrage                           = '3';
        public static final char CompetingMarketMaker                        = '4';
        public static final char ActingAsMarketMakerOrSpecialistInSecurity   = '5';
        public static final char ActingAsMarketMakerOrSpecialistInUnderlying = '6';
        public static final char ForeignEntity                               = '7';
        public static final char ExternalMarketParticipant                   = '8';
        public static final char ExternalInterConnectedMarketLinkage         = '9';
        public static final char RisklessArbitrage                           = 'A';

        private OrderRestrictionsValues() {
        }

    }

    /**
     * Values for MassCancelRequestType(530).
     */
    public static class MassCancelRequestTypeValues {

        public static final char CancelOrdersForASecurity            = '1';
        public static final char CancelOrdersForAnUnderlyingSecurity = '2';
        public static final char CancelOrdersForAProduct             = '3';
        public static final char CancelOrdersForACFICode             = '4';
        public static final char CancelOrdersForASecurityType        = '5';
        public static final char CancelOrdersForATradingSession      = '6';
        public static final char CancelAllOrders                     = '7';

        private MassCancelRequestTypeValues() {
        }

    }

    /**
     * Values for MassCancelResponse(531).
     */
    public static class MassCancelResponseValues {

        public static final char CancelRequestRejected               = '0';
        public static final char CancelOrdersForASecurity            = '1';
        public static final char CancelOrdersForAnUnderlyingSecurity = '2';
        public static final char CancelOrdersForAProduct             = '3';
        public static final char CancelOrdersForACFICode             = '4';
        public static final char CancelOrdersForASecurityType        = '5';
        public static final char CancelOrdersForATradingSession      = '6';
        public static final char CancelAllOrders                     = '7';

        private MassCancelResponseValues() {
        }

    }

    /**
     * Values for MassCancelRejectReason(532).
     */
    public static class MassCancelRejectReasonValues {

        public static final int MassCancelNotSupported            =  0;
        public static final int InvalidOrUnknownSecurity          =  1;
        public static final int InvalidOrUnkownUnderlyingSecurity =  2;
        public static final int InvalidOrUnknownProduct           =  3;
        public static final int InvalidOrUnknownCFICode           =  4;
        public static final int InvalidOrUnknownSecurityType      =  5;
        public static final int InvalidOrUnknownTradingSession    =  6;
        public static final int Other                             = 99;

        private MassCancelRejectReasonValues() {
        }

    }

    /**
     * Values for QuoteType(537).
     */
    public static class QuoteTypeValues {

        public static final int Indicative          = 0;
        public static final int Tradeable           = 1;
        public static final int RestrictedTradeable = 2;
        public static final int Counter             = 3;

        private QuoteTypeValues() {
        }

    }

    /**
     * Values for CashMargin(544).
     */
    public static class CashMarginValues {

        public static final char Cash        = '1';
        public static final char MarginOpen  = '2';
        public static final char MarginClose = '3';

        private CashMarginValues() {
        }

    }

    /**
     * Values for Scope(546).
     */
    public static class ScopeValues {

        public static final char LocalMarket = '1';
        public static final char National    = '2';
        public static final char Global      = '3';

        private ScopeValues() {
        }

    }

    /**
     * Values for CrossType(549).
     */
    public static class CrossTypeValues {

        public static final int CrossAON       = 1;
        public static final int CrossIOC       = 2;
        public static final int CrossOneSide   = 3;
        public static final int CrossSamePrice = 4;

        private CrossTypeValues() {
        }

    }

    /**
     * Values for CrossPrioritization(550).
     */
    public static class CrossPrioritizationValues {

        public static final int None                  = 0;
        public static final int BuySideIsPrioritized  = 1;
        public static final int SellSideIsPrioritized = 2;

        private CrossPrioritizationValues() {
        }

    }

    /**
     * Values for NoSides(552).
     */
    public static class NoSidesValues {

        public static final int OneSide   = 1;
        public static final int BothSides = 2;

        private NoSidesValues() {
        }

    }

    /**
     * Values for SecurityListRequestType(559).
     */
    public static class SecurityListRequestTypeValues {

        public static final int Symbol           = 0;
        public static final int SecurityTypeAnd  = 1;
        public static final int Product          = 2;
        public static final int TradingSessionID = 3;
        public static final int AllSecurities    = 4;

        private SecurityListRequestTypeValues() {
        }

    }

    /**
     * Values for SecurityRequestResult(560).
     */
    public static class SecurityRequestResultValues {

        public static final int ValidRequest                          = 0;
        public static final int InvalidOrUnsupportedRequest           = 1;
        public static final int NoInstrumentsFound                    = 2;
        public static final int NotAuthorizedToRetrieveInstrumentData = 3;
        public static final int InstrumentDataTemporarilyUnavailable  = 4;
        public static final int RequestForInstrumentDataNotSupported  = 5;

        private SecurityRequestResultValues() {
        }

    }

    /**
     * Values for MultiLegRptTypeReq(563).
     */
    public static class MultiLegRptTypeReqValues {

        public static final int ReportByMulitlegSecurityOnly              = 0;
        public static final int ReportByMultilegSecurityAndInstrumentLegs = 1;
        public static final int ReportByInstrumentLegsOnly                = 2;

        private MultiLegRptTypeReqValues() {
        }

    }

    /**
     * Values for TradSesStatusRejReason(567).
     */
    public static class TradSesStatusRejReasonValues {

        public static final int UnknownOrInvalidTradingSessionID =  1;
        public static final int Other                            = 99;

        private TradSesStatusRejReasonValues() {
        }

    }

    /**
     * Values for TradeRequestType(569).
     */
    public static class TradeRequestTypeValues {

        public static final int AllTrades                         = 0;
        public static final int MatchedTradesMatchingCriteria     = 1;
        public static final int UnmatchedTradesThatMatchCriteria  = 2;
        public static final int UnreportedTradesThatMatchCriteria = 3;
        public static final int AdvisoriesThatMatchCriteria       = 4;

        private TradeRequestTypeValues() {
        }

    }

    /**
     * Values for MatchStatus(573).
     */
    public static class MatchStatusValues {

        public static final char Compared        = '0';
        public static final char Uncompared      = '1';
        public static final char AdvisoryOrAlert = '2';

        private MatchStatusValues() {
        }

    }

    /**
     * Values for MatchType(574).
     */
    public static class MatchTypeValues {

        public static final String ExactMatchPlus4BadgesExecTime          = "A1";
        public static final String ExactMatchPlus4Badges                  = "A2";
        public static final String ACTAcceptedTrade                       = "M3";
        public static final String ExactMatchPlus2BadgesExecTime          = "A3";
        public static final String ACTDefaultTrade                        = "M4";
        public static final String ExactMatchPlus2Badges                  = "A4";
        public static final String ACTDefaultAfterM2                      = "M5";
        public static final String ExactMatchPlusExecTime                 = "A5";
        public static final String ACTM6Match                             = "M6";
        public static final String StampedAdvisoriesOrSpecialistAccepts   = "AQ";
        public static final String A1ExactMatchSummarizedQuantity         = "S1";
        public static final String A2ExactMatchSummarizedQuantity         = "S2";
        public static final String A3ExactMatchSummarizedQuantity         = "S3";
        public static final String A4ExactMatchSummarizedQuantity         = "S4";
        public static final String A5ExactMatchSummarizedQuantity         = "S5";
        public static final String ExactMatchMinusBadgesTimes             = "M1";
        public static final String SummarizedMatchMinusBadgesTimes        = "M2";
        public static final String OCSLockedIn                            = "MT";
        public static final String OnePartyPrivatelyNegotiatedTradeReport = "60";
        public static final String TwoPartyPrivatelyNegotiatedTradeReport = "61";
        public static final String ContinuousAutoMatch                    = "62";
        public static final String CrossAuction1                          = "63";
        public static final String CounterOrderSelection1                 = "64";
        public static final String CallAuction1                           = "65";
        public static final String OnePartyTradeReport                    = "1";
        public static final String TwoPartyTradeReport                    = "2";
        public static final String ConfirmedTradeReport                   = "3";
        public static final String AutoMatch                              = "4";
        public static final String CrossAuction2                          = "5";
        public static final String CounterOrderSelection2                 = "6";
        public static final String CallAuction2                           = "7";

        private MatchTypeValues() {
        }

    }

    /**
     * Values for ClearingInstruction(577).
     */
    public static class ClearingInstructionValues {

        public static final int ProcessNormally                   =  0;
        public static final int ExcludeFromAllNetting             =  1;
        public static final int BilateralNettingOnly              =  2;
        public static final int ExClearing                        =  3;
        public static final int SpecialTrade                      =  4;
        public static final int MultilateralNetting               =  5;
        public static final int ClearAgainstCentralCounterparty   =  6;
        public static final int ExcludeFromCentralCounterparty    =  7;
        public static final int ManualMode                        =  8;
        public static final int AutomaticPostingMode              =  9;
        public static final int AutomaticGiveUpMode               = 10;
        public static final int QualifiedServiceRepresentativeQSR = 11;
        public static final int CustomerTrade                     = 12;
        public static final int SelfClearing                      = 13;

        private ClearingInstructionValues() {
        }

    }

    /**
     * Values for AccountType(581).
     */
    public static class AccountTypeValues {

        public static final int CarriedCustomerSide                 = 1;
        public static final int CarriedNonCustomerSide              = 2;
        public static final int HouseTrader                         = 3;
        public static final int FloorTrader                         = 4;
        public static final int CarriedNonCustomerSideCrossMargined = 6;
        public static final int HouseTraderCrossMargined            = 7;
        public static final int JointBackOfficeAccount              = 8;

        private AccountTypeValues() {
        }

    }

    /**
     * Values for CustOrderCapacity(582).
     */
    public static class CustOrderCapacityValues {

        public static final int MemberTradingForTheirOwnAccount             = 1;
        public static final int ClearingFirmTradingForItsProprietaryAccount = 2;
        public static final int MemberTradingForAnotherMember               = 3;
        public static final int AllOther                                    = 4;

        private CustOrderCapacityValues() {
        }

    }

    /**
     * Values for MassStatusReqType(585).
     */
    public static class MassStatusReqTypeValues {

        public static final int StatusForOrdersForASecurity            = 1;
        public static final int StatusForOrdersForAnUnderlyingSecurity = 2;
        public static final int StatusForOrdersForAProduct             = 3;
        public static final int StatusForOrdersForACFICode             = 4;
        public static final int StatusForOrdersForASecurityType        = 5;
        public static final int StatusForOrdersForATradingSession      = 6;
        public static final int StatusForAllOrders                     = 7;
        public static final int StatusForOrdersForAPartyID             = 8;

        private MassStatusReqTypeValues() {
        }

    }

    /**
     * Values for DayBookingInst(589).
     */
    public static class DayBookingInstValues {

        public static final char Auto                                 = '0';
        public static final char SpeakWithOrderInitiatorBeforeBooking = '1';
        public static final char Accumulate                           = '2';

        private DayBookingInstValues() {
        }

    }

    /**
     * Values for BookingUnit(590).
     */
    public static class BookingUnitValues {

        public static final char EachPartialExecutionIsABookableUnit   = '0';
        public static final char AggregatePartialExecutionsOnThisOrder = '1';
        public static final char AggregateExecutionsForThisSymbol      = '2';

        private BookingUnitValues() {
        }

    }

    /**
     * Values for PreallocMethod(591).
     */
    public static class PreallocMethodValues {

        public static final char ProRata      = '0';
        public static final char DoNotProRata = '1';

        private PreallocMethodValues() {
        }

    }

    /**
     * Values for AllocType(626).
     */
    public static class AllocTypeValues {

        public static final int Calculated                           =  1;
        public static final int Preliminary                          =  2;
        public static final int SellsideCalculatedUsingPreliminary   =  3;
        public static final int SellsideCalculatedWithoutPreliminary =  4;
        public static final int ReadyToBook                          =  5;
        public static final int BuysideReadyToBook                   =  6;
        public static final int WarehouseInstruction                 =  7;
        public static final int RequestToIntermediary                =  8;
        public static final int Accept                               =  9;
        public static final int Reject                               = 10;
        public static final int AcceptPending                        = 11;
        public static final int IncompleteGroup                      = 12;
        public static final int CompleteGroup                        = 13;
        public static final int ReversalPending                      = 14;

        private AllocTypeValues() {
        }

    }

    /**
     * Values for ClearingFeeIndicator(635).
     */
    public static class ClearingFeeIndicatorValues {

        public static final String FirstYearDelegate             = "1";
        public static final String SecondYearDelegate            = "2";
        public static final String ThirdYearDelegate             = "3";
        public static final String FourthYearDelegate            = "4";
        public static final String FifthYearDelegate             = "5";
        public static final String SixthYearDelegate             = "9";
        public static final String CBOEMember                    = "B";
        public static final String NonMemberAndCustomer          = "C";
        public static final String EquityMemberAndClearingMember = "E";
        public static final String FullAndAssociateMember        = "F";
        public static final String Firms106HAnd106J              = "H";
        public static final String GIM                           = "I";
        public static final String Lessee106FEmployees           = "L";
        public static final String AllOtherOwnershipTypes        = "M";

        private ClearingFeeIndicatorValues() {
        }

    }

    /**
     * Values for PriorityIndicator(638).
     */
    public static class PriorityIndicatorValues {

        public static final int PriorityUnchanged                 = 0;
        public static final int LostPriorityAsResultOfOrderChange = 1;

        private PriorityIndicatorValues() {
        }

    }

    /**
     * Values for QuoteRequestRejectReason(658).
     */
    public static class QuoteRequestRejectReasonValues {

        public static final int UnknownSymbol               =  1;
        public static final int Exchange                    =  2;
        public static final int QuoteRequestExceedsLimit    =  3;
        public static final int TooLateToEnter              =  4;
        public static final int InvalidPrice                =  5;
        public static final int NotAuthorizedToRequestQuote =  6;
        public static final int NoMatchForInquiry           =  7;
        public static final int NoMarketForInstrument       =  8;
        public static final int NoInventory                 =  9;
        public static final int Pass                        = 10;
        public static final int InsufficientCredit          = 11;
        public static final int Other                       = 99;

        private QuoteRequestRejectReasonValues() {
        }

    }

    /**
     * Values for AcctIDSource(660).
     */
    public static class AcctIDSourceValues {

        public static final int BIC      =  1;
        public static final int SIDCode  =  2;
        public static final int TFM      =  3;
        public static final int OMGEO    =  4;
        public static final int DTCCCode =  5;
        public static final int Other    = 99;

        private AcctIDSourceValues() {
        }

    }

    /**
     * Values for ConfirmStatus(665).
     */
    public static class ConfirmStatusValues {

        public static final int Received                      = 1;
        public static final int MismatchedAccount             = 2;
        public static final int MissingSettlementInstructions = 3;
        public static final int Confirmed                     = 4;
        public static final int RequestRejected               = 5;

        private ConfirmStatusValues() {
        }

    }

    /**
     * Values for ConfirmTransType(666).
     */
    public static class ConfirmTransTypeValues {

        public static final int New     = 0;
        public static final int Replace = 1;
        public static final int Cancel  = 2;

        private ConfirmTransTypeValues() {
        }

    }

    /**
     * Values for DeliveryForm(668).
     */
    public static class DeliveryFormValues {

        public static final int BookEntry = 1;
        public static final int Bearer    = 2;

        private DeliveryFormValues() {
        }

    }

    /**
     * Values for LegSwapType(690).
     */
    public static class LegSwapTypeValues {

        public static final int ParForPar        = 1;
        public static final int ModifiedDuration = 2;
        public static final int Risk             = 4;
        public static final int Proceeds         = 5;

        private LegSwapTypeValues() {
        }

    }

    /**
     * Values for QuotePriceType(692).
     */
    public static class QuotePriceTypeValues {

        public static final int Percent     =  1;
        public static final int PerShare    =  2;
        public static final int FixedAmount =  3;
        public static final int Discount    =  4;
        public static final int Premium     =  5;
        public static final int Spread      =  6;
        public static final int TEDPrice    =  7;
        public static final int TEDYield    =  8;
        public static final int YieldSpread =  9;
        public static final int Yield       = 10;

        private QuotePriceTypeValues() {
        }

    }

    /**
     * Values for QuoteRespType(694).
     */
    public static class QuoteRespTypeValues {

        public static final int Hit      = 1;
        public static final int Counter  = 2;
        public static final int Expired  = 3;
        public static final int Cover    = 4;
        public static final int DoneAway = 5;
        public static final int Pass     = 6;

        private QuoteRespTypeValues() {
        }

    }

    /**
     * Values for PosType(703).
     */
    public static class PosTypeValues {

        public static final String AllocationTradeQty        = "ALC";
        public static final String OptionAssignment          = "AS";
        public static final String AsOfTradeQty              = "ASF";
        public static final String DeliveryQty               = "DLV";
        public static final String ElectronicTradeQty        = "ETR";
        public static final String OptionExerciseQty         = "EX";
        public static final String EndOfDayQty               = "FIN";
        public static final String IntraSpreadQty            = "IAS";
        public static final String InterSpreadQty            = "IES";
        public static final String AdjustmentQty             = "PA";
        public static final String PitTradeQty               = "PIT";
        public static final String StartOfDayQty             = "SOD";
        public static final String IntegralSplit             = "SPL";
        public static final String TransactionFromAssignment = "TA";
        public static final String TotalTransactionQty       = "TOT";
        public static final String TransactionQuantity       = "TQ";
        public static final String TransferTradeQty          = "TRF";
        public static final String TransactionFromExercise   = "TX";
        public static final String CrossMarginQty            = "XM";
        public static final String ReceiveQuantity           = "RCV";
        public static final String CorporateActionAdjustment = "CAA";
        public static final String DeliveryNoticeQty         = "DN";
        public static final String ExchangeForPhysicalQty    = "EP";

        private PosTypeValues() {
        }

    }

    /**
     * Values for PosQtyStatus(706).
     */
    public static class PosQtyStatusValues {

        public static final int Submitted = 0;
        public static final int Accepted  = 1;
        public static final int Rejected  = 2;

        private PosQtyStatusValues() {
        }

    }

    /**
     * Values for PosAmtType(707).
     */
    public static class PosAmtTypeValues {

        public static final String CashAmount                    = "CASH";
        public static final String CashResidualAmount            = "CRES";
        public static final String FinalMarkToMarketAmount       = "FMTM";
        public static final String IncrementalMarkToMarketAmount = "IMTM";
        public static final String PremiumAmount                 = "PREM";
        public static final String StartOfDayMarkToMarketAmount  = "SMTM";
        public static final String TradeVariationAmount          = "TVAR";
        public static final String ValueAdjustedAmount           = "VADJ";
        public static final String SettlementValue               = "SETL";

        private PosAmtTypeValues() {
        }

    }

    /**
     * Values for PosTransType(709).
     */
    public static class PosTransTypeValues {

        public static final int Exercise                 = 1;
        public static final int DoNotExercise            = 2;
        public static final int PositionAdjustment       = 3;
        public static final int PositionChangeSubmission = 4;
        public static final int Pledge                   = 5;
        public static final int LargeTraderSubmission    = 6;

        private PosTransTypeValues() {
        }

    }

    /**
     * Values for PosMaintAction(712).
     */
    public static class PosMaintActionValues {

        public static final int New     = 1;
        public static final int Replace = 2;
        public static final int Cancel  = 3;
        public static final int Reverse = 4;

        private PosMaintActionValues() {
        }

    }

    /**
     * Values for SettlSessID(716).
     */
    public static class SettlSessIDValues {

        public static final String Intraday               = "ITD";
        public static final String RegularTradingHours    = "RTH";
        public static final String ElectronicTradingHours = "ETH";
        public static final String EndOfDay               = "EOD";

        private SettlSessIDValues() {
        }

    }

    /**
     * Values for AdjustmentType(718).
     */
    public static class AdjustmentTypeValues {

        public static final int ProcessRequestAsMarginDisposition = 0;
        public static final int DeltaPlus                         = 1;
        public static final int DeltaMinus                        = 2;
        public static final int Final                             = 3;

        private AdjustmentTypeValues() {
        }

    }

    /**
     * Values for PosMaintStatus(722).
     */
    public static class PosMaintStatusValues {

        public static final int Accepted              = 0;
        public static final int AcceptedWithWarnings  = 1;
        public static final int Rejected              = 2;
        public static final int Completed             = 3;
        public static final int CompletedWithWarnings = 4;

        private PosMaintStatusValues() {
        }

    }

    /**
     * Values for PosMaintResult(723).
     */
    public static class PosMaintResultValues {

        public static final int SuccessfulCompletion =  0;
        public static final int Rejected             =  1;
        public static final int Other                = 99;

        private PosMaintResultValues() {
        }

    }

    /**
     * Values for PosReqType(724).
     */
    public static class PosReqTypeValues {

        public static final int Positions          = 0;
        public static final int Trades             = 1;
        public static final int Exercises          = 2;
        public static final int Assignments        = 3;
        public static final int SettlementActivity = 4;
        public static final int BackoutMessage     = 5;

        private PosReqTypeValues() {
        }

    }

    /**
     * Values for ResponseTransportType(725).
     */
    public static class ResponseTransportTypeValues {

        public static final int Inband    = 0;
        public static final int OutOfBand = 1;

        private ResponseTransportTypeValues() {
        }

    }

    /**
     * Values for PosReqResult(728).
     */
    public static class PosReqResultValues {

        public static final int ValidRequest                      =  0;
        public static final int InvalidOrUnsupportedRequest       =  1;
        public static final int NoPositionsFoundThatMatchCriteria =  2;
        public static final int NotAuthorizedToRequestPositions   =  3;
        public static final int RequestForPositionNotSupported    =  4;
        public static final int Other                             = 99;

        private PosReqResultValues() {
        }

    }

    /**
     * Values for PosReqStatus(729).
     */
    public static class PosReqStatusValues {

        public static final int Completed             = 0;
        public static final int CompletedWithWarnings = 1;
        public static final int Rejected              = 2;

        private PosReqStatusValues() {
        }

    }

    /**
     * Values for SettlPriceType(731).
     */
    public static class SettlPriceTypeValues {

        public static final int Final       = 1;
        public static final int Theoretical = 2;

        private SettlPriceTypeValues() {
        }

    }

    /**
     * Values for AssignmentMethod(744).
     */
    public static class AssignmentMethodValues {

        public static final char ProRata = 'P';
        public static final char Random  = 'R';

        private AssignmentMethodValues() {
        }

    }

    /**
     * Values for ExerciseMethod(747).
     */
    public static class ExerciseMethodValues {

        public static final char Automatic = 'A';
        public static final char Manual    = 'M';

        private ExerciseMethodValues() {
        }

    }

    /**
     * Values for TradeRequestResult(749).
     */
    public static class TradeRequestResultValues {

        public static final int Successful                    =  0;
        public static final int InvalidOrUnknownInstrument    =  1;
        public static final int InvalidTypeOfTradeRequested   =  2;
        public static final int InvalidParties                =  3;
        public static final int InvalidTransportTypeRequested =  4;
        public static final int InvalidDestinationRequested   =  5;
        public static final int TradeRequestTypeNotSupported  =  8;
        public static final int NotAuthorized                 =  9;
        public static final int Other                         = 99;

        private TradeRequestResultValues() {
        }

    }

    /**
     * Values for TradeRequestStatus(750).
     */
    public static class TradeRequestStatusValues {

        public static final int Accepted  = 0;
        public static final int Completed = 1;
        public static final int Rejected  = 2;

        private TradeRequestStatusValues() {
        }

    }

    /**
     * Values for TradeReportRejectReason(751).
     */
    public static class TradeReportRejectReasonValues {

        public static final int Successful                 =  0;
        public static final int InvalidPartyOnformation    =  1;
        public static final int UnknownInstrument          =  2;
        public static final int UnauthorizedToReportTrades =  3;
        public static final int InvalidTradeType           =  4;
        public static final int Other                      = 99;

        private TradeReportRejectReasonValues() {
        }

    }

    /**
     * Values for SideMultiLegReportingType(752).
     */
    public static class SideMultiLegReportingTypeValues {

        public static final int SingleSecurity                   = 1;
        public static final int IndividualLegOfAMultilegSecurity = 2;
        public static final int MultilegSecurity                 = 3;

        private SideMultiLegReportingTypeValues() {
        }

    }

    /**
     * Values for TrdRegTimestampType(770).
     */
    public static class TrdRegTimestampTypeValues {

        public static final int ExecutionTime   = 1;
        public static final int TimeIn          = 2;
        public static final int TimeOut         = 3;
        public static final int BrokerReceipt   = 4;
        public static final int BrokerExecution = 5;
        public static final int DeskReceipt     = 6;

        private TrdRegTimestampTypeValues() {
        }

    }

    /**
     * Values for ConfirmType(773).
     */
    public static class ConfirmTypeValues {

        public static final int Status                      = 1;
        public static final int Confirmation                = 2;
        public static final int ConfirmationRequestRejected = 3;

        private ConfirmTypeValues() {
        }

    }

    /**
     * Values for ConfirmRejReason(774).
     */
    public static class ConfirmRejReasonValues {

        public static final int MismatchedAccount             =  1;
        public static final int MissingSettlementInstructions =  2;
        public static final int Other                         = 99;

        private ConfirmRejReasonValues() {
        }

    }

    /**
     * Values for BookingType(775).
     */
    public static class BookingTypeValues {

        public static final int RegularBooking  = 0;
        public static final int CFD             = 1;
        public static final int TotalReturnSwap = 2;

        private BookingTypeValues() {
        }

    }

    /**
     * Values for AllocSettlInstType(780).
     */
    public static class AllocSettlInstTypeValues {

        public static final int UseDefaultInstructions       = 0;
        public static final int DeriveFromParametersProvided = 1;
        public static final int FullDetailsProvided          = 2;
        public static final int SSIDBIDsProvided             = 3;
        public static final int PhoneForInstructions         = 4;

        private AllocSettlInstTypeValues() {
        }

    }

    /**
     * Values for DlvyInstType(787).
     */
    public static class DlvyInstTypeValues {

        public static final char Cash       = 'C';
        public static final char Securities = 'S';

        private DlvyInstTypeValues() {
        }

    }

    /**
     * Values for TerminationType(788).
     */
    public static class TerminationTypeValues {

        public static final int Overnight = 1;
        public static final int Term      = 2;
        public static final int Flexible  = 3;
        public static final int Open      = 4;

        private TerminationTypeValues() {
        }

    }

    /**
     * Values for SettlInstReqRejCode(792).
     */
    public static class SettlInstReqRejCodeValues {

        public static final int UnableToProcessRequest                =  0;
        public static final int UnknownAccount                        =  1;
        public static final int NoMatchingSettlementInstructionsFound =  2;
        public static final int Other                                 = 99;

        private SettlInstReqRejCodeValues() {
        }

    }

    /**
     * Values for AllocReportType(794).
     */
    public static class AllocReportTypeValues {

        public static final int PreliminaryRequestToIntermediary     =  2;
        public static final int SellsideCalculatedUsingPreliminary   =  3;
        public static final int SellsideCalculatedWithoutPreliminary =  4;
        public static final int WarehouseRecap                       =  5;
        public static final int RequestToIntermediary                =  8;
        public static final int Accept                               =  9;
        public static final int Reject                               = 10;
        public static final int AcceptPending                        = 11;
        public static final int Complete                             = 12;
        public static final int ReversePending                       = 14;

        private AllocReportTypeValues() {
        }

    }

    /**
     * Values for AllocCancReplaceReason(796).
     */
    public static class AllocCancReplaceReasonValues {

        public static final int OriginalDetailsIncomplete      =  1;
        public static final int ChangeInUnderlyingOrderDetails =  2;
        public static final int Other                          = 99;

        private AllocCancReplaceReasonValues() {
        }

    }

    /**
     * Values for AllocAccountType(798).
     */
    public static class AllocAccountTypeValues {

        public static final int CarriedCustomerSide                 = 1;
        public static final int CarriedNonCustomerSide              = 2;
        public static final int HouseTrader                         = 3;
        public static final int FloorTrader                         = 4;
        public static final int CarriedNonCustomerSideCrossMargined = 6;
        public static final int HouseTraderCrossMargined            = 7;
        public static final int JointBackOfficeAccount              = 8;

        private AllocAccountTypeValues() {
        }

    }

    /**
     * Values for PartySubIDType(803).
     */
    public static class PartySubIDTypeValues {

        public static final int Firm                             =  1;
        public static final int Person                           =  2;
        public static final int System                           =  3;
        public static final int Application                      =  4;
        public static final int FullLegalNameOfFirm              =  5;
        public static final int PostalAddress                    =  6;
        public static final int PhoneNumber                      =  7;
        public static final int EmailAddress                     =  8;
        public static final int ContactName                      =  9;
        public static final int SecuritiesAccountNumber          = 10;
        public static final int RegistrationNumber               = 11;
        public static final int RegisteredAddressForConfirmation = 12;
        public static final int RegulatoryStatus                 = 13;
        public static final int RegistrationName                 = 14;
        public static final int CashAccountNumber                = 15;
        public static final int BIC                              = 16;
        public static final int CSDParticipantMemberCode         = 17;
        public static final int RegisteredAddress                = 18;
        public static final int FundAccountName                  = 19;
        public static final int TelexNumber                      = 20;
        public static final int FaxNumber                        = 21;
        public static final int SecuritiesAccountName            = 22;
        public static final int CashAccountName                  = 23;
        public static final int Department                       = 24;
        public static final int LocationDesk                     = 25;
        public static final int PositionAccountType              = 26;
        public static final int SecurityLocateID                 = 27;
        public static final int MarketMaker                      = 28;
        public static final int EligibleCounterparty             = 29;
        public static final int ProfessionalClient               = 30;
        public static final int Location                         = 31;
        public static final int ExecutionVenue                   = 32;

        private PartySubIDTypeValues() {
        }

    }

    /**
     * Values for AllocIntermedReqType(808).
     */
    public static class AllocIntermedReqTypeValues {

        public static final int PendingAccept      = 1;
        public static final int PendingRelease     = 2;
        public static final int PendingReversal    = 3;
        public static final int Accept             = 4;
        public static final int BlockLevelReject   = 5;
        public static final int AccountLevelReject = 6;

        private AllocIntermedReqTypeValues() {
        }

    }

    /**
     * Values for ApplQueueResolution(814).
     */
    public static class ApplQueueResolutionValues {

        public static final int NoActionTaken = 0;
        public static final int QueueFlushed  = 1;
        public static final int OverlayLast   = 2;
        public static final int EndSession    = 3;

        private ApplQueueResolutionValues() {
        }

    }

    /**
     * Values for ApplQueueAction(815).
     */
    public static class ApplQueueActionValues {

        public static final int NoActionTaken = 0;
        public static final int QueueFlushed  = 1;
        public static final int OverlayLast   = 2;
        public static final int EndSession    = 3;

        private ApplQueueActionValues() {
        }

    }

    /**
     * Values for AvgPxIndicator(819).
     */
    public static class AvgPxIndicatorValues {

        public static final int NoAveragePricing = 0;
        public static final int Trade            = 1;
        public static final int LastTrade        = 2;

        private AvgPxIndicatorValues() {
        }

    }

    /**
     * Values for TradeAllocIndicator(826).
     */
    public static class TradeAllocIndicatorValues {

        public static final int AllocationNotRequired             = 0;
        public static final int AllocationRequired                = 1;
        public static final int UseAllocationProvidedWithTheTrade = 2;
        public static final int AllocationGiveUpExecutor          = 3;
        public static final int AllocationFromExecutor            = 4;
        public static final int AllocationToClaimAccount          = 5;

        private TradeAllocIndicatorValues() {
        }

    }

    /**
     * Values for ExpirationCycle(827).
     */
    public static class ExpirationCycleValues {

        public static final int ExpireOnTradingSessionClose = 0;
        public static final int ExpireOnTradingSessionOpen  = 1;

        private ExpirationCycleValues() {
        }

    }

    /**
     * Values for TrdType(828).
     */
    public static class TrdTypeValues {

        public static final int RegularTrade                     =  0;
        public static final int BlockTrade                       =  1;
        public static final int EFP                              =  2;
        public static final int Transfer                         =  3;
        public static final int LateTrade                        =  4;
        public static final int TTrade                           =  5;
        public static final int WeightedAveragePriceTrade        =  6;
        public static final int BunchedTrade                     =  7;
        public static final int LateBunchedTrade                 =  8;
        public static final int PriorReferencePriceTrade         =  9;
        public static final int AfterHoursTrade                  = 10;
        public static final int ExchangeForRisk                  = 11;
        public static final int ExchangeForSwap                  = 12;
        public static final int ExchangeOfFuturesFor             = 13;
        public static final int ExchangeOfOptionsForOptions      = 14;
        public static final int TradingAtSettlement              = 15;
        public static final int AllOrNone                        = 16;
        public static final int FuturesLargeOrderExecution       = 17;
        public static final int ExchangeOfFuturesForFutures      = 18;
        public static final int OptionInterimTrade               = 19;
        public static final int OptionCabinetTrade               = 20;
        public static final int PrivatelyNegotiatedTrades        = 22;
        public static final int SubstitutionOfFuturesForForwards = 23;
        public static final int ErrorTrade                       = 24;
        public static final int SpecialCumDividend               = 25;
        public static final int SpecialExDividend                = 26;
        public static final int SpecialCumCoupon                 = 27;
        public static final int SpecialExCoupon                  = 28;
        public static final int CashSettlement                   = 29;
        public static final int SpecialPrice                     = 30;
        public static final int GuaranteedDelivery               = 31;
        public static final int SpecialCumRights                 = 32;
        public static final int SpecialExRights                  = 33;
        public static final int SpecialCumCapitalRepayments      = 34;
        public static final int SpecialExCapitalRepayments       = 35;
        public static final int SpecialCumBonus                  = 36;
        public static final int SpecialExBonus                   = 37;
        public static final int LargeTrade                       = 38;
        public static final int WorkedPrincipalTrade             = 39;
        public static final int BlockTrades                      = 40;
        public static final int NameChange                       = 41;
        public static final int PortfolioTransfer                = 42;
        public static final int ProrogationBuy                   = 43;
        public static final int ProrogationSell                  = 44;
        public static final int OptionExercise                   = 45;
        public static final int DeltaNeutralTransaction          = 46;
        public static final int FinancingTransaction             = 47;

        private TrdTypeValues() {
        }

    }

    /**
     * Values for TrdSubType(829).
     */
    public static class TrdSubTypeValues {

        public static final int CMTA                                      =  0;
        public static final int InternalTransferOrAdjustment              =  1;
        public static final int ExternalTransferOrTransferOfAccount       =  2;
        public static final int RejectForSubmittingSide                   =  3;
        public static final int AdvisoryForContraSide                     =  4;
        public static final int OffsetDueToAnAllocation                   =  5;
        public static final int OnsetDueToAnAllocation                    =  6;
        public static final int DifferentialSpread                        =  7;
        public static final int ImpliedSpreadLegExecutedAgainstAnOutright =  8;
        public static final int TransactionFromExercise                   =  9;
        public static final int TransactionFromAssignment                 = 10;
        public static final int ACATS                                     = 11;
        public static final int AI                                        = 14;
        public static final int B                                         = 15;
        public static final int K                                         = 16;
        public static final int LC                                        = 17;
        public static final int M                                         = 18;
        public static final int N                                         = 19;
        public static final int NM                                        = 20;
        public static final int NR                                        = 21;
        public static final int P                                         = 22;
        public static final int PA                                        = 23;
        public static final int PC                                        = 24;
        public static final int PN                                        = 25;
        public static final int R                                         = 26;
        public static final int RO                                        = 27;
        public static final int RT                                        = 28;
        public static final int SW                                        = 29;
        public static final int T                                         = 30;
        public static final int WN                                        = 31;
        public static final int WT                                        = 32;

        private TrdSubTypeValues() {
        }

    }

    /**
     * Values for PegMoveType(835).
     */
    public static class PegMoveTypeValues {

        public static final int Floating = 0;
        public static final int Fixed    = 1;

        private PegMoveTypeValues() {
        }

    }

    /**
     * Values for PegOffsetType(836).
     */
    public static class PegOffsetTypeValues {

        public static final int Price       = 0;
        public static final int BasisPoints = 1;
        public static final int Ticks       = 2;
        public static final int PriceTier   = 3;

        private PegOffsetTypeValues() {
        }

    }

    /**
     * Values for PegLimitType(837).
     */
    public static class PegLimitTypeValues {

        public static final int OrBetter = 0;
        public static final int Strict   = 1;
        public static final int OrWorse  = 2;

        private PegLimitTypeValues() {
        }

    }

    /**
     * Values for PegRoundDirection(838).
     */
    public static class PegRoundDirectionValues {

        public static final int MoreAggressive = 1;
        public static final int MorePassive    = 2;

        private PegRoundDirectionValues() {
        }

    }

    /**
     * Values for PegScope(840).
     */
    public static class PegScopeValues {

        public static final int Local                  = 1;
        public static final int National               = 2;
        public static final int Global                 = 3;
        public static final int NationalExcludingLocal = 4;

        private PegScopeValues() {
        }

    }

    /**
     * Values for DiscretionMoveType(841).
     */
    public static class DiscretionMoveTypeValues {

        public static final int Floating = 0;
        public static final int Fixed    = 1;

        private DiscretionMoveTypeValues() {
        }

    }

    /**
     * Values for DiscretionOffsetType(842).
     */
    public static class DiscretionOffsetTypeValues {

        public static final int Price       = 0;
        public static final int BasisPoints = 1;
        public static final int Ticks       = 2;
        public static final int PriceTier   = 3;

        private DiscretionOffsetTypeValues() {
        }

    }

    /**
     * Values for DiscretionLimitType(843).
     */
    public static class DiscretionLimitTypeValues {

        public static final int OrBetter = 0;
        public static final int Strict   = 1;
        public static final int OrWorse  = 2;

        private DiscretionLimitTypeValues() {
        }

    }

    /**
     * Values for DiscretionRoundDirection(844).
     */
    public static class DiscretionRoundDirectionValues {

        public static final int MoreAggressive = 1;
        public static final int MorePassive    = 2;

        private DiscretionRoundDirectionValues() {
        }

    }

    /**
     * Values for DiscretionScope(846).
     */
    public static class DiscretionScopeValues {

        public static final int Local                  = 1;
        public static final int National               = 2;
        public static final int Global                 = 3;
        public static final int NationalExcludingLocal = 4;

        private DiscretionScopeValues() {
        }

    }

    /**
     * Values for TargetStrategy(847).
     */
    public static class TargetStrategyValues {

        public static final int VWAP                 = 1;
        public static final int Participate          = 2;
        public static final int MininizeMarketImpact = 3;

        private TargetStrategyValues() {
        }

    }

    /**
     * Values for LastLiquidityInd(851).
     */
    public static class LastLiquidityIndValues {

        public static final int AddedLiquidity     = 1;
        public static final int RemovedLiquidity   = 2;
        public static final int LiquidityRoutedOut = 3;

        private LastLiquidityIndValues() {
        }

    }

    /**
     * Values for ShortSaleReason(853).
     */
    public static class ShortSaleReasonValues {

        public static final int DealerSoldShort                   = 0;
        public static final int DealerSoldShortExempt             = 1;
        public static final int SellingCustomerSoldShort          = 2;
        public static final int SellingCustomerSoldShortExempt    = 3;
        public static final int QualifiedServiceRepresentative    = 4;
        public static final int QSROrAGUContraSideSoldShortExempt = 5;

        private ShortSaleReasonValues() {
        }

    }

    /**
     * Values for QtyType(854).
     */
    public static class QtyTypeValues {

        public static final int Units                     = 0;
        public static final int Contracts                 = 1;
        public static final int UnitsOfMeasurePerTimeUnit = 2;

        private QtyTypeValues() {
        }

    }

    /**
     * Values for TradeReportType(856).
     */
    public static class TradeReportTypeValues {

        public static final int Submit                   =  0;
        public static final int Alleged                  =  1;
        public static final int Accept                   =  2;
        public static final int Decline                  =  3;
        public static final int Addendum                 =  4;
        public static final int No                       =  5;
        public static final int TradeReportCancel        =  6;
        public static final int LockedIn                 =  7;
        public static final int Defaulted                =  8;
        public static final int InvalidCMTA              =  9;
        public static final int Pended                   = 10;
        public static final int AllegedNew               = 11;
        public static final int AllegedAddendum          = 12;
        public static final int AllegedNo                = 13;
        public static final int AllegedTradeReportCancel = 14;
        public static final int AllegedTradeBreak        = 15;

        private TradeReportTypeValues() {
        }

    }

    /**
     * Values for AllocNoOrdersType(857).
     */
    public static class AllocNoOrdersTypeValues {

        public static final int NotSpecified         = 0;
        public static final int ExplicitListProvided = 1;

        private AllocNoOrdersTypeValues() {
        }

    }

    /**
     * Values for EventType(865).
     */
    public static class EventTypeValues {

        public static final int Put             =  1;
        public static final int Call            =  2;
        public static final int Tender          =  3;
        public static final int SinkingFundCall =  4;
        public static final int Activation      =  5;
        public static final int Inactiviation   =  6;
        public static final int Other           = 99;

        private EventTypeValues() {
        }

    }

    /**
     * Values for InstrAttribType(871).
     */
    public static class InstrAttribTypeValues {

        public static final int Flat                           =  1;
        public static final int ZeroCoupon                     =  2;
        public static final int InterestBearing                =  3;
        public static final int NoPeriodicPayments             =  4;
        public static final int VariableRate                   =  5;
        public static final int LessFeeForPut                  =  6;
        public static final int SteppedCoupon                  =  7;
        public static final int CouponPeriod                   =  8;
        public static final int When                           =  9;
        public static final int OriginalIssueDiscount          = 10;
        public static final int Callable                       = 11;
        public static final int EscrowedToMaturity             = 12;
        public static final int EscrowedToRedemptionDate       = 13;
        public static final int PreRefunded                    = 14;
        public static final int InDefault                      = 15;
        public static final int Unrated                        = 16;
        public static final int Taxable                        = 17;
        public static final int Indexed                        = 18;
        public static final int SubjectToAlternativeMinimumTax = 19;
        public static final int OriginalIssueDiscountPrice     = 20;
        public static final int CallableBelowMaturityValue     = 21;
        public static final int CallableWithoutNotice          = 22;
        public static final int Text                           = 99;

        private InstrAttribTypeValues() {
        }

    }

    /**
     * Values for CPProgram(875).
     */
    public static class CPProgramValues {

        public static final int Program3a3 =  1;
        public static final int Program42  =  2;
        public static final int Other      = 99;

        private CPProgramValues() {
        }

    }

    /**
     * Values for MiscFeeBasis(891).
     */
    public static class MiscFeeBasisValues {

        public static final int Absolute   = 0;
        public static final int PerUnit    = 1;
        public static final int Percentage = 2;

        private MiscFeeBasisValues() {
        }

    }

    /**
     * Values for CollAsgnReason(895).
     */
    public static class CollAsgnReasonValues {

        public static final int Initial                 = 0;
        public static final int Scheduled               = 1;
        public static final int TimeWarning             = 2;
        public static final int MarginDeficiency        = 3;
        public static final int MarginExcess            = 4;
        public static final int ForwardCollateralDemand = 5;
        public static final int EventOfDefault          = 6;
        public static final int AdverseTaxEvent         = 7;

        private CollAsgnReasonValues() {
        }

    }

    /**
     * Values for CollInquiryQualifier(896).
     */
    public static class CollInquiryQualifierValues {

        public static final int TradeDate            = 0;
        public static final int GCInstrument         = 1;
        public static final int CollateralInstrument = 2;
        public static final int SubstitutionEligible = 3;
        public static final int NotAssigned          = 4;
        public static final int PartiallyAssigned    = 5;
        public static final int FullyAssigned        = 6;
        public static final int OutstandingTrades    = 7;

        private CollInquiryQualifierValues() {
        }

    }

    /**
     * Values for CollAsgnTransType(903).
     */
    public static class CollAsgnTransTypeValues {

        public static final int New     = 0;
        public static final int Replace = 1;
        public static final int Cancel  = 2;
        public static final int Release = 3;
        public static final int Reverse = 4;

        private CollAsgnTransTypeValues() {
        }

    }

    /**
     * Values for CollAsgnRespType(905).
     */
    public static class CollAsgnRespTypeValues {

        public static final int Received = 0;
        public static final int Accepted = 1;
        public static final int Declined = 2;
        public static final int Rejected = 3;

        private CollAsgnRespTypeValues() {
        }

    }

    /**
     * Values for CollAsgnRejectReason(906).
     */
    public static class CollAsgnRejectReasonValues {

        public static final int UnknownDeal                =  0;
        public static final int UnknownOrInvalidInstrument =  1;
        public static final int UnauthorizedTransaction    =  2;
        public static final int InsufficientCollateral     =  3;
        public static final int InvalidTypeOfCollateral    =  4;
        public static final int ExcessiveSubstitution      =  5;
        public static final int Other                      = 99;

        private CollAsgnRejectReasonValues() {
        }

    }

    /**
     * Values for CollStatus(910).
     */
    public static class CollStatusValues {

        public static final int Unassigned         = 0;
        public static final int PartiallyAssigned  = 1;
        public static final int AssignmentProposed = 2;
        public static final int Assigned           = 3;
        public static final int Challenged         = 4;

        private CollStatusValues() {
        }

    }

    /**
     * Values for DeliveryType(919).
     */
    public static class DeliveryTypeValues {

        public static final int VersusPayment = 0;
        public static final int Free          = 1;
        public static final int TriParty      = 2;
        public static final int HoldInCustody = 3;

        private DeliveryTypeValues() {
        }

    }

    /**
     * Values for UserRequestType(924).
     */
    public static class UserRequestTypeValues {

        public static final int LogOnUser                   = 1;
        public static final int LogOffUser                  = 2;
        public static final int ChangePasswordForUser       = 3;
        public static final int RequestIndividualUserStatus = 4;

        private UserRequestTypeValues() {
        }

    }

    /**
     * Values for UserStatus(926).
     */
    public static class UserStatusValues {

        public static final int LoggedIn          = 1;
        public static final int NotLoggedIn       = 2;
        public static final int UserNotRecognised = 3;
        public static final int PasswordIncorrect = 4;
        public static final int PasswordChanged   = 5;
        public static final int Other             = 6;

        private UserStatusValues() {
        }

    }

    /**
     * Values for StatusValue(928).
     */
    public static class StatusValueValues {

        public static final int Connected              = 1;
        public static final int NotConnectedUnexpected = 2;
        public static final int NotConnectedExpected   = 3;
        public static final int InProcess              = 4;

        private StatusValueValues() {
        }

    }

    /**
     * Values for NetworkRequestType(935).
     */
    public static class NetworkRequestTypeValues {

        public static final int Snapshot        = 1;
        public static final int Subscribe       = 2;
        public static final int StopSubscribing = 4;
        public static final int LevelOfDetail   = 8;

        private NetworkRequestTypeValues() {
        }

    }

    /**
     * Values for NetworkStatusResponseType(937).
     */
    public static class NetworkStatusResponseTypeValues {

        public static final int Full              = 1;
        public static final int IncrementalUpdate = 2;

        private NetworkStatusResponseTypeValues() {
        }

    }

    /**
     * Values for TrdRptStatus(939).
     */
    public static class TrdRptStatusValues {

        public static final int Accepted           = 0;
        public static final int Rejected           = 1;
        public static final int AcceptedWithErrors = 3;

        private TrdRptStatusValues() {
        }

    }

    /**
     * Values for AffirmStatus(940).
     */
    public static class AffirmStatusValues {

        public static final int Received        = 1;
        public static final int ConfirmRejected = 2;
        public static final int Affirmed        = 3;

        private AffirmStatusValues() {
        }

    }

    /**
     * Values for CollAction(944).
     */
    public static class CollActionValues {

        public static final int Retain = 0;
        public static final int Add    = 1;
        public static final int Remove = 2;

        private CollActionValues() {
        }

    }

    /**
     * Values for CollInquiryStatus(945).
     */
    public static class CollInquiryStatusValues {

        public static final int Accepted              = 0;
        public static final int AcceptedWithWarnings  = 1;
        public static final int Completed             = 2;
        public static final int CompletedWithWarnings = 3;
        public static final int Rejected              = 4;

        private CollInquiryStatusValues() {
        }

    }

    /**
     * Values for CollInquiryResult(946).
     */
    public static class CollInquiryResultValues {

        public static final int Successful                            =  0;
        public static final int InvalidOrUnknownInstrument            =  1;
        public static final int InvalidOrUnknownCollateralType        =  2;
        public static final int InvalidParties                        =  3;
        public static final int InvalidTransportTypeRequested         =  4;
        public static final int InvalidDestinationRequested           =  5;
        public static final int NoCollateralFoundForTheTradeSpecified =  6;
        public static final int NoCollateralFoundForTheOrderSpecified =  7;
        public static final int CollateralInquiryTypeNotSupported     =  8;
        public static final int UnauthorizedForCollateralInquiry      =  9;
        public static final int Other                                 = 99;

        private CollInquiryResultValues() {
        }

    }

    /**
     * Values for StrategyParameterType(959).
     */
    public static class StrategyParameterTypeValues {

        public static final int Int                 =  1;
        public static final int Length              =  2;
        public static final int NumInGroup          =  3;
        public static final int SeqNum              =  4;
        public static final int TagNum              =  5;
        public static final int Float               =  6;
        public static final int Qty                 =  7;
        public static final int Price               =  8;
        public static final int PriceOffset         =  9;
        public static final int Amt                 = 10;
        public static final int Percentage          = 11;
        public static final int Char                = 12;
        public static final int Boolean             = 13;
        public static final int String              = 14;
        public static final int MultipleCharValue   = 15;
        public static final int Currency            = 16;
        public static final int Exchange            = 17;
        public static final int MonthYear           = 18;
        public static final int UTCTimestamp        = 19;
        public static final int UTCTimeOnly         = 20;
        public static final int LocalMktDate        = 21;
        public static final int UTCDateOnly         = 22;
        public static final int Data                = 23;
        public static final int MultipleStringValue = 24;

        private StrategyParameterTypeValues() {
        }

    }

    /**
     * Values for SecurityStatus(965).
     */
    public static class SecurityStatusValues {

        public static final String Active   = "1";
        public static final String Inactive = "2";

        private SecurityStatusValues() {
        }

    }

    /**
     * Values for UnderlyingCashType(974).
     */
    public static class UnderlyingCashTypeValues {

        public static final String FIXED = "FIXED";
        public static final String DIFF  = "DIFF";

        private UnderlyingCashTypeValues() {
        }

    }

    /**
     * Values for UnderlyingSettlementType(975).
     */
    public static class UnderlyingSettlementTypeValues {

        public static final int TPlus1 = 2;
        public static final int TPlus3 = 4;
        public static final int TPlus4 = 5;

        private UnderlyingSettlementTypeValues() {
        }

    }

    /**
     * Values for SecurityUpdateAction(980).
     */
    public static class SecurityUpdateActionValues {

        public static final char Add    = 'A';
        public static final char Delete = 'D';
        public static final char Modify = 'M';

        private SecurityUpdateActionValues() {
        }

    }

    /**
     * Values for ExpType(982).
     */
    public static class ExpTypeValues {

        public static final int AutoExercise         = 1;
        public static final int NonAutoExercise      = 2;
        public static final int FinalWillBeExercised = 3;
        public static final int ContraryIntention    = 4;
        public static final int Difference           = 5;

        private ExpTypeValues() {
        }

    }

    /**
     * Values for IndividualAllocType(992).
     */
    public static class IndividualAllocTypeValues {

        public static final int SubAllocate          = 1;
        public static final int ThirdPartyAllocation = 2;

        private IndividualAllocTypeValues() {
        }

    }

    /**
     * Values for UnitofMeasure(996).
     */
    public static class UnitofMeasureValues {

        public static final String Barrels          = "Bbl";
        public static final String BillionCubicFeet = "Bcf";
        public static final String Bushels          = "Bu";
        public static final String Pounds           = "lbs";
        public static final String Gallons          = "Gal";
        public static final String MillionBarrels   = "MMbbl";
        public static final String OneMillionBTU    = "MMBtu";
        public static final String MegawattHours    = "MWh";
        public static final String TroyOunces       = "oz_tr";
        public static final String MetricTons       = "t";
        public static final String Tons             = "tn";
        public static final String USDollars        = "USD";

        private UnitofMeasureValues() {
        }

    }

    /**
     * Values for TimeUnit(997).
     */
    public static class TimeUnitValues {

        public static final String Hour   = "H";
        public static final String Minute = "Min";
        public static final String Second = "S";
        public static final String Day    = "D";
        public static final String Week   = "Wk";
        public static final String Month  = "Mo";
        public static final String Year   = "Yr";

        private TimeUnitValues() {
        }

    }

    /**
     * Values for AllocMethod(1002).
     */
    public static class AllocMethodValues {

        public static final int Automatic = 1;
        public static final int Guarantor = 2;
        public static final int Manual    = 3;

        private AllocMethodValues() {
        }

    }

    /**
     * Values for AsOfIndicator(1015).
     */
    public static class AsOfIndicatorValues {

        public static final char False = '0';
        public static final char True  = '1';

        private AsOfIndicatorValues() {
        }

    }

    /**
     * Values for MDBookType(1021).
     */
    public static class MDBookTypeValues {

        public static final int TopOfBook  = 1;
        public static final int PriceDepth = 2;
        public static final int OrderDepth = 3;

        private MDBookTypeValues() {
        }

    }

    /**
     * Values for MDOriginType(1024).
     */
    public static class MDOriginTypeValues {

        public static final int Book    = 0;
        public static final int OffBook = 1;
        public static final int Cross   = 2;

        private MDOriginTypeValues() {
        }

    }

    /**
     * Values for CustOrderHandlingInst(1031).
     */
    public static class CustOrderHandlingInstValues {

        public static final String AddOnOrder                     = "ADD";
        public static final String AllOrNone                      = "AON";
        public static final String CashNotHeld                    = "CNH";
        public static final String DirectedOrder                  = "DIR";
        public static final String ExchangeForPhysicalTransaction = "E.W";
        public static final String FillOrKill                     = "FOK";
        public static final String ImbalanceOnly                  = "IO";
        public static final String ImmediateOrCancel              = "IOC";
        public static final String LimitOnOpen                    = "LOO";
        public static final String LimitOnClose                   = "LOC";
        public static final String MarketAtOpen                   = "MAO";
        public static final String MarketAtClose                  = "MAC";
        public static final String MarketOnOpen                   = "MOO";
        public static final String MarketOnClose                  = "MOC";
        public static final String MinimumQuantity                = "MQT";
        public static final String NotHeld                        = "NH";
        public static final String OverTheDay                     = "OVD";
        public static final String Pegged                         = "PEG";
        public static final String ReserveSizeOrder               = "RSV";
        public static final String StopStockTransaction           = "S.W";
        public static final String Scale                          = "SCL";
        public static final String TimeOrder                      = "TMO";
        public static final String TrailingStop                   = "TS";
        public static final String Work                           = "WRK";

        private CustOrderHandlingInstValues() {
        }

    }

    /**
     * Values for OrderHandlingInstSource(1032).
     */
    public static class OrderHandlingInstSourceValues {

        public static final int NASDOATS = 1;

        private OrderHandlingInstSourceValues() {
        }

    }

    /**
     * Values for DeskType(1033).
     */
    public static class DeskTypeValues {

        public static final String Agency           = "A";
        public static final String Arbitrage        = "AR";
        public static final String Derivatives      = "D";
        public static final String International    = "IN";
        public static final String Institutional    = "IS";
        public static final String Other            = "O";
        public static final String PreferredTrading = "PF";
        public static final String Proprietary      = "PR";
        public static final String ProgramTrading   = "PT";
        public static final String Sales            = "S";
        public static final String Trading          = "T";

        private DeskTypeValues() {
        }

    }

    /**
     * Values for DeskTypeSource(1034).
     */
    public static class DeskTypeSourceValues {

        public static final int NASDOATS = 1;

        private DeskTypeSourceValues() {
        }

    }

    /**
     * Values for DeskOrderHandlingInst(1035).
     */
    public static class DeskOrderHandlingInstValues {

        public static final String AddOnOrder                     = "ADD";
        public static final String AllOrNone                      = "AON";
        public static final String CashNotHeld                    = "CNH";
        public static final String DirectedOrder                  = "DIR";
        public static final String ExchangeForPhysicalTransaction = "E.W";
        public static final String FillOrKill                     = "FOK";
        public static final String ImbalanceOnly                  = "IO";
        public static final String ImmediateOrCancel              = "IOC";
        public static final String LimitOnOpen                    = "LOO";
        public static final String LimitOnClose                   = "LOC";
        public static final String MarketAtOpen                   = "MAO";
        public static final String MarketAtClose                  = "MAC";
        public static final String MarketOnOpen                   = "MOO";
        public static final String MarketOnClose                  = "MOC";
        public static final String MinimumQuantity                = "MQT";
        public static final String NotHeld                        = "NH";
        public static final String OverTheDay                     = "OVD";
        public static final String Pegged                         = "PEG";
        public static final String ReserveSizeOrder               = "RSV";
        public static final String StopStockTransaction           = "S.W";
        public static final String Scale                          = "SCL";
        public static final String TimeOrder                      = "TMO";
        public static final String TrailingStop                   = "TS";
        public static final String Work                           = "WRK";

        private DeskOrderHandlingInstValues() {
        }

    }

    /**
     * Values for ExecAckStatus(1036).
     */
    public static class ExecAckStatusValues {

        public static final char Received = '0';
        public static final char Accepted = '1';
        public static final char Don      = '2';

        private ExecAckStatusValues() {
        }

    }

    /**
     * Values for CollApplType(1043).
     */
    public static class CollApplTypeValues {

        public static final int SpecificDeposit = 0;
        public static final int General         = 1;

        private CollApplTypeValues() {
        }

    }

    /**
     * Values for UnderlyingFXRateCalc(1046).
     */
    public static class UnderlyingFXRateCalcValues {

        public static final char Divide   = 'D';
        public static final char Multiply = 'M';

        private UnderlyingFXRateCalcValues() {
        }

    }

    /**
     * Values for AllocPositionEffect(1047).
     */
    public static class AllocPositionEffectValues {

        public static final char Open   = 'O';
        public static final char Close  = 'C';
        public static final char Rolled = 'R';
        public static final char FIFO   = 'F';

        private AllocPositionEffectValues() {
        }

    }

    /**
     * Values for InstrmtAssignmentMethod(1049).
     */
    public static class InstrmtAssignmentMethodValues {

        public static final char Random  = 'R';
        public static final char ProRata = 'P';

        private InstrmtAssignmentMethodValues() {
        }

    }

    /**
     * Values for MDQuoteType(1070).
     */
    public static class MDQuoteTypeValues {

        public static final int Indicative             = 0;
        public static final int Tradeable              = 1;
        public static final int RestrictedTradeable    = 2;
        public static final int Counter                = 3;
        public static final int IndicativeAndTradeable = 4;

        private MDQuoteTypeValues() {
        }

    }

    /**
     * Values for RefOrderIDSource(1081).
     */
    public static class RefOrderIDSourceValues {

        public static final char SecondaryOrderID = '0';
        public static final char OrderID          = '1';
        public static final char MDEntryID        = '2';
        public static final char QuoteEntryID     = '3';

        private RefOrderIDSourceValues() {
        }

    }

    /**
     * Values for DisplayWhen(1083).
     */
    public static class DisplayWhenValues {

        public static final char Immediate = '1';
        public static final char Exhaust   = '2';

        private DisplayWhenValues() {
        }

    }

    /**
     * Values for DisplayMethod(1084).
     */
    public static class DisplayMethodValues {

        public static final char Initial = '1';
        public static final char New     = '2';
        public static final char Random  = '3';

        private DisplayMethodValues() {
        }

    }

    /**
     * Values for PriceProtectionScope(1092).
     */
    public static class PriceProtectionScopeValues {

        public static final char None     = '0';
        public static final char Local    = '1';
        public static final char National = '2';
        public static final char Global   = '3';

        private PriceProtectionScopeValues() {
        }

    }

    /**
     * Values for LotType(1093).
     */
    public static class LotTypeValues {

        public static final char OddLot   = '1';
        public static final char RoundLot = '2';
        public static final char BlockLot = '3';

        private LotTypeValues() {
        }

    }

    /**
     * Values for PegPriceType(1094).
     */
    public static class PegPriceTypeValues {

        public static final int LastPeg                                    = 1;
        public static final int MidPricePeg                                = 2;
        public static final int OpeningPeg                                 = 3;
        public static final int MarketPeg                                  = 4;
        public static final int PrimaryPeg                                 = 5;
        public static final int FixedPegToLocalBestBidOrOfferAtTimeOfOrder = 6;
        public static final int PegToVWAP                                  = 7;
        public static final int TrailingStopPeg                            = 8;
        public static final int PegToLimitPrice                            = 9;

        private PegPriceTypeValues() {
        }

    }

    /**
     * Values for TriggerType(1100).
     */
    public static class TriggerTypeValues {

        public static final char PartialExecution        = '1';
        public static final char SpecifiedTradingSession = '2';
        public static final char NextAuction             = '3';
        public static final char PriceMovement           = '4';

        private TriggerTypeValues() {
        }

    }

    /**
     * Values for TriggerAction(1101).
     */
    public static class TriggerActionValues {

        public static final char Activate = '1';
        public static final char Modify   = '2';
        public static final char Cancel   = '3';

        private TriggerActionValues() {
        }

    }

    /**
     * Values for TriggerPriceType(1107).
     */
    public static class TriggerPriceTypeValues {

        public static final char BestOffer            = '1';
        public static final char LastTrade            = '2';
        public static final char BestBid              = '3';
        public static final char BestBidOrLastTrade   = '4';
        public static final char BestOfferOrLastTrade = '5';
        public static final char BestMid              = '6';

        private TriggerPriceTypeValues() {
        }

    }

    /**
     * Values for TriggerPriceTypeScope(1108).
     */
    public static class TriggerPriceTypeScopeValues {

        public static final char None     = '0';
        public static final char Local    = '1';
        public static final char National = '2';
        public static final char Global   = '3';

        private TriggerPriceTypeScopeValues() {
        }

    }

    /**
     * Values for TriggerPriceDirection(1109).
     */
    public static class TriggerPriceDirectionValues {

        public static final char Up   = 'U';
        public static final char Down = 'D';

        private TriggerPriceDirectionValues() {
        }

    }

    /**
     * Values for TriggerOrderType(1111).
     */
    public static class TriggerOrderTypeValues {

        public static final char Market = '1';
        public static final char Limit  = '2';

        private TriggerOrderTypeValues() {
        }

    }

    /**
     * Values for OrderCategory(1115).
     */
    public static class OrderCategoryValues {

        public static final char Order                    = '1';
        public static final char Quote                    = '2';
        public static final char PrivatelyNegotiatedTrade = '3';
        public static final char MultilegOrder            = '4';
        public static final char LinkedOrder              = '5';
        public static final char QuoteRequest             = '6';
        public static final char ImpliedOrder             = '7';
        public static final char CrossOrder               = '8';

        private OrderCategoryValues() {
        }

    }

    /**
     * Values for TradeHandlingInstr(1123).
     */
    public static class TradeHandlingInstrValues {

        public static final char TradeConfirmation            = '0';
        public static final char TwoPartyReport               = '1';
        public static final char OnePartyReportForMatching    = '2';
        public static final char OnePartyReportForPassThrough = '3';
        public static final char AutomatedFloorOrderRouting   = '4';

        private TradeHandlingInstrValues() {
        }

    }

    /**
     * Values for ApplVerID(1128).
     */
    public static class ApplVerIDValues {

        public static final String FIX27 = "0";
        public static final String FIX30 = "1";
        public static final String FIX40 = "2";
        public static final String FIX41 = "3";
        public static final String FIX42 = "4";
        public static final String FIX43 = "5";
        public static final String FIX44 = "6";
        public static final String FIX50 = "7";

        private ApplVerIDValues() {
        }

    }

    /**
     * Values for ExDestinationIDSource(1133).
     */
    public static class ExDestinationIDSourceValues {

        public static final char BIC               = 'B';
        public static final char GeneralIdentifier = 'C';
        public static final char Proprietary       = 'D';
        public static final char ISOCountryCode    = 'E';
        public static final char MIC               = 'G';

        private ExDestinationIDSourceValues() {
        }

    }

    private FIX50Enumerations() {
    }

}
