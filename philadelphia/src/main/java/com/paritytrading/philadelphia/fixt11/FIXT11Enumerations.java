package com.paritytrading.philadelphia.fixt11;

/**
 * Enumerations for FIXT 1.1.
 */
public class FIXT11Enumerations {

    /**
     * Values for EncryptMethod(98).
     */
    public static class EncryptMethodValues {

        public static final int NoneOther = 0;
        public static final int PKCS      = 1;
        public static final int DES       = 2;
        public static final int PKCSDES   = 3;
        public static final int PGPDES    = 4;
        public static final int PGPDESMD5 = 5;
        public static final int PEMDESMD5 = 6;

        private EncryptMethodValues() {
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
        public static final int CompidProblem                             =  9;
        public static final int SendingtimeAccuracyProblem                = 10;
        public static final int InvalidMsgtype                            = 11;
        public static final int XMLValidationError                        = 12;
        public static final int TagAppearsMoreThanOnce                    = 13;
        public static final int TagSpecifiedOutOfRequiredOrder            = 14;
        public static final int RepeatingGroupFieldsOutOfOrder            = 15;
        public static final int IncorrectNumingroupCountForRepeatingGroup = 16;
        public static final int NonDataValueIncludesFieldDelimiter        = 17;
        public static final int InvalidUnsupportedApplicationVersion      = 18;
        public static final int Other                                     = 99;

        private SessionRejectReasonValues() {
        }

    }

    /**
     * Values for ApplVerID(1128).
     */
    public static class ApplVerIDValues {

        public static final String FIX27    = "0";
        public static final String FIX30    = "1";
        public static final String FIX40    = "2";
        public static final String FIX41    = "3";
        public static final String FIX42    = "4";
        public static final String FIX43    = "5";
        public static final String FIX44    = "6";
        public static final String FIX50    = "7";
        public static final String FIX50SP1 = "8";

        private ApplVerIDValues() {
        }

    }

    /**
     * Values for SessionStatus(1409).
     */
    public static class SessionStatusValues {

        public static final int SessionActive                             = 0;
        public static final int SessionPasswordChanged                    = 1;
        public static final int SessionPasswordDueToExpire                = 2;
        public static final int NewSessionPasswordDoesNotComplyWithPolicy = 3;
        public static final int SessionLogoutComplete                     = 4;
        public static final int InvalidUsernameOrPassword                 = 5;
        public static final int AccountLocked                             = 6;
        public static final int LogonsAreNotAllowedAtThisTime             = 7;
        public static final int PasswordExpired                           = 8;

        private SessionStatusValues() {
        }

    }

    private FIXT11Enumerations() {
    }

}
