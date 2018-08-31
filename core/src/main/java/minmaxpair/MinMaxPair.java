package minmaxpair;

/**
 * Class MinMaxPair.
 * Implements IMinMax interface.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2018
 */
public class MinMaxPair implements IMinMax {
    /**
     * Class Pair.
     * Contains min and max.
     */
    public static class Pair {
        /**
         * Min.
         */
        private int min = 0;
        /**
         * Max.
         */
        private int max = 0;

        /**
         * Method gets min.
         *
         * @return Min.
         */
        public final int getMin() {
            return this.min;
        }

        /**
         * Method sets min.
         *
         * @param aMin Min.
         */
        public final void setMin(final int aMin) {
            this.min = aMin;
        }

        /**
         * Method gets max.
         *
         * @return Max.
         */
        public final int getMax() {
            return this.max;
        }

        /**
         * Method sets max.
         *
         * @param aMax Max.
         */
        public final void setMax(final int aMax) {
            this.max = aMax;
        }
    }

    /**
     * Method gets min() and max() as a pair.
     *
     * @param anArray Array.
     * @return Pair(min, max).
     */
    @Override
    public final Pair getMinMax(final int[] anArray) {
        Pair result = new Pair();

        IMin min = (int[] array) -> {

            int resultMin = anArray[0];

            for (int i = 0; i < anArray.length; i++) {
                resultMin = Math.min(resultMin, anArray[i]);
            }

            return resultMin;
        };

        IMax max = new IMax() {
            @Override
            public int getMax(final int[] anArray) {
                int result = anArray[0];

                for (int i = 0; i < anArray.length; i++) {
                    result = Math.max(result, anArray[i]);
                }

                return result;
            }
        };

        result.setMin(min.getMin(anArray));
        result.setMax(max.getMax(anArray));

        return result;
    }
}
