from modules.Maze import Maze
from modules.Position import Position
from modules.Stack import Stack


def findpath(maze):
    current_pos = Position(0, 0)
    stack = Stack()
    for line in maze.items:
        print(line)
    maze.mark(current_pos)

    while current_pos.x != maze.col-1 and current_pos.y != maze.row-1:

        print("mic check (", current_pos.x, ",", current_pos.y, ")")

        if maze.check_visited(current_pos.check_up()) == 0:
            stack.push(current_pos)
            current_pos = current_pos.check_up()
            maze.mark(current_pos)
        elif maze.check_visited(current_pos.check_down()) == 0:
            stack.push(current_pos)
            current_pos = current_pos.check_down()
            maze.mark(current_pos)
        elif maze.check_visited(current_pos.check_left()) == 0:
            stack.push(current_pos)
            current_pos = current_pos.check_left()
            maze.mark(current_pos)
        elif maze.check_visited(current_pos.check_right()) == 0:
            stack.push(current_pos)
            current_pos = current_pos.check_right()
            maze.mark(current_pos)
        else:
            if stack.isEmpty():
                return False
            print("--- backtracking from (", current_pos.x, ",", current_pos.y, ")")
            current_pos = stack.pop()

    return True


def main():
    # print the maze
    newMaze = Maze(0, 0)
    print(findpath(newMaze))


if __name__ == "__main__":
    main()