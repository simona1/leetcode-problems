# LeetCode problem # 1436, 'Destination City'
# https://leetcode.com/problems/destination-city/

# @param {String[][]} paths
# @return {String}
def dest_city(paths)
    (Set.new(paths.map { |p| p[1] }) - paths.map { |p| p[0] }).first
end