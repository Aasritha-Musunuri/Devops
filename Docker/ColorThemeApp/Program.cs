var builder = WebApplication.CreateBuilder(args);

var app = builder.Build();

app.UseDefaultFiles();
app.UseStaticFiles();

app.MapGet("/api/color/{color}", (string color) =>
{
    var allowedColors = new[] { "red", "green", "blue", "yellow" };

    if (!allowedColors.Contains(color.ToLower()))
    {
        return Results.BadRequest(new
        {
            message = "Invalid color"
        });
    }

    return Results.Ok(new
    {
        color = color.ToLower()
    });
});

app.Run();