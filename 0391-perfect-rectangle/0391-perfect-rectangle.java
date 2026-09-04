class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
       int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int areaSum = 0;

        Set<String> corners = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

            // Update bounding box
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            // Calculate area
            areaSum += (x2 - x1) * (y2 - y1);

            // Process corners
            String[] points = {
                x1 + " " + y1,
                x1 + " " + y2,
                x2 + " " + y1,
                x2 + " " + y2
            };

            for (String p : points) {
                if (!corners.add(p)) corners.remove(p);  // cancel if duplicate
            }
        }

        // Final check for 4 corners
        if (corners.size() != 4) return false;

        // Check that the 4 corners are the bounding rectangle's corners
        String bottomLeft = minX + " " + minY;
        String topLeft = minX + " " + maxY;
        String bottomRight = maxX + " " + minY;
        String topRight = maxX + " " + maxY;

        if (!corners.contains(bottomLeft) || !corners.contains(topLeft) ||
            !corners.contains(bottomRight) || !corners.contains(topRight))
            return false;

        // Check total area
        int boundingArea = (maxX - minX) * (maxY - minY);
        return areaSum == boundingArea;
    }
}

    